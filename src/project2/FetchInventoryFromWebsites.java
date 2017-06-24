package project2;



	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.Collection;

	public class FetchInventoryFromWebsites {
		public static void main(String args[]) throws Exception {
                    
			fetchInventoryAndStore();
		}

		private static void fetchInventoryAndStore() throws Exception {
			Collection<Dealer> dealers = getDealers();
			for (Dealer d : dealers) {
				Collection<Vehicle> vehicles = fetchInventory(d);
				storeVehicles(vehicles, d.getId());
			}

		}

		private static void storeVehicles(Collection<Vehicle> vehicles, String webId) throws Exception {
			File f = new File("data/" +webId);
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println("id~webId~category~year~make~model~trim~type~price~photo");
			StringBuilder builder = new StringBuilder();
			boolean start = false;
			for (Vehicle v : vehicles) {
				if (start == true) {
					builder.append("\n");
				} else {
					start = true;
				}
				builder.append(v.toString());
			}
			pw.println(builder.toString());
			pw.flush();
			pw.close();
		}

		private static Collection<Vehicle> fetchInventory(Dealer d) throws Exception {
			URL u = new URL("http://" + d.getUrl() + "/searchVehiclesXML.ajax");
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			reader.readLine();
			while (true) {
				String line = reader.readLine();
				// System.out.println(line);
				if (line == null)
					break;
				addVehicle(line, vehicles);
			}
			reader.close();

			return vehicles;
		}

		private static void addVehicle(String line, Collection<Vehicle> vehicles) {
			if (!line.contains("Vehicle id=")) {
				return;
			}
			vehicles.add(makeVehicle(line));
		}

		private static Vehicle makeVehicle(String line) {
                        String id = getString(line, "id");
			String category = getString(line, "category");
			String make = getString(line, "make");
			String model = getString(line, "model");
			String price = getString(line, "featuredPrice");
			String photo = getString(line, "photo");
			String trim = getString(line, "trim");
			String webId = getString(line, "webId");
			String year = getString(line, "year");
			String type = getString(line, "bodyType");
                        Vehicle v=new Vehicle(id,Integer.parseInt(year), make, model, trim, type, Float.parseFloat(price));
			return v;

		}

		private static String getString(String x, String key) {
			String find = key + "=\"";
			int l = find.length();
			int start = x.indexOf(find) + l;
			int end = x.indexOf("\"", start);
			return x.substring(start, end);
		}

		private static Collection<Dealer> getDealers() throws Exception {
			File f = new File("data/dealers");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			Collection<Dealer> dealers = new ArrayList<Dealer>();
			// reader.readLine();
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				Dealer d = new Dealer();
				String x[] = line.split("\\\t");
				d.setUrl(x[2]);
				d.setId(x[0]);
				dealers.add(d);
			}
			reader.close();
			return dealers;

		}

	}

	




