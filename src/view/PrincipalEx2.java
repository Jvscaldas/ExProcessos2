package view;

import javax.swing.JOptionPane;

import controller.Ex2Controller;

public class PrincipalEx2 {

	public static void main(String[] args) {

		Ex2Controller ex2 = new Ex2Controller();
		String os = null;
		System.out.println(os);
		int opc = 0;
		int pid;
		String nome;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					" 1 - Identificar Sistema Operacional \n 2 - Listar Processos  \n 3 - Matar processo por Pid \n 4 - Matar processo por nome \n 9 - Encerrar"));
			switch (opc) {
			case 1:
				os = ex2.os();
				break;
			case 2:
				ex2.readProcess(os);
				break;
			case 3:
				pid = Integer.parseInt(JOptionPane.showInputDialog("Informe o Pid do processo que deseja encerrar: "));
				ex2.killProcessPid(pid, os);
				break;
			case 4:
				System.out.println("Digite o nome do processo: ");
				nome = JOptionPane.showInputDialog("Informe o Nome do processo que deseja encerrar: ");
				ex2.killProcessName(nome, os);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}
	}
}
