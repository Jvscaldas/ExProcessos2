package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex2Controller {

	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void readProcess(String os) {
		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("lsof");
			} else {
				process = Runtime.getRuntime().exec("tasklist");
			}
			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			fluxo.close();
			buffer.close();
			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void killProcessPid(int pid, String os) {

		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("kill -15 " + pid);
			} else {
				process = Runtime.getRuntime().exec("taskkill /pid " + pid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void killProcessName(String name, String os) {
		Process process;
		try {
			if (os.contains("Linux")) {
				process = Runtime.getRuntime().exec("killall " + name);
			} else {
				process = Runtime.getRuntime().exec("taskkill /im " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
