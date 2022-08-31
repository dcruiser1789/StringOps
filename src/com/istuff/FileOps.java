	package com.istuff;

	import java.io.*;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.time.LocalTime;
	import java.util.stream.Stream;

	public class FileOps {
		File resource;
		FileOps(File fileName) throws IOException {
			this.resource=fileName;
		}
		public String getByFileReader(){
            StringBuilder strFile=null;
			try {

                Reader rdr = new FileReader(this.resource);
				BufferedReader bfr = new BufferedReader(rdr);
				String line= bfr.readLine();
				while (line!= null) {
					line= bfr.readLine();
				}
			} catch (
					IOException e) {
				e.printStackTrace();
			}
            return strFile.toString();
		}
		public String getByPaths() {
			StringBuilder strFile=null;
			Path pth = Paths.get(this.resource.toURI());
			try (BufferedReader bfr = Files.newBufferedReader(pth)) {
				String line = bfr.readLine();
				while (line != null) {
					strFile.append(line);
					line = bfr.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return strFile.toString();
		}
		public String getByLines() {
			Path pth = Paths.get(this.resource.toURI());
			StringBuilder strFile = new StringBuilder();
			try (BufferedReader bfr = Files.newBufferedReader(pth)){
				Files.lines(pth).forEach(strFile::append);
			} catch (IOException e) {
				e.printStackTrace();
			}
            return strFile.toString();
		}

		public String getByStream() {
			Path pth = Paths.get(this.resource.toURI());
			StringBuilder strFile = null;
		  try(Stream<String>  lines = Files.newBufferedReader(pth).lines()){
			  lines.forEach(strFile::append);
				} catch (IOException e) {
					e.printStackTrace();
				}
			return strFile.toString();
		}

	}
