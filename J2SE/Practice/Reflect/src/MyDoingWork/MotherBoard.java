package MyDoingWork;
/*主板:
 * 
 * */
public class MotherBoard {
	public void run()
	{
		System.out.println("MotherBoard Run...............");
	}
	//实现规则就运行
	public void Pci_Run(PCI pci)
	{
		pci.open();
		pci.close();
	}
	
}
