package MyDoingWork;
/*����:
 * 
 * */
public class MotherBoard {
	public void run()
	{
		System.out.println("MotherBoard Run...............");
	}
	//ʵ�ֹ��������
	public void Pci_Run(PCI pci)
	{
		pci.open();
		pci.close();
	}
	
}
