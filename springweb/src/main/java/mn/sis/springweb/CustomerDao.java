package mn.sis.springweb;

import java.util.List;

import mn.sis.menu.Modul;

public interface CustomerDao
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public List<Modul> findModelMenu();
}
