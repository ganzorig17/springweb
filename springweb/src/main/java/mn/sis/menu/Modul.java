package mn.sis.menu;

import java.util.ArrayList;
import java.util.List;

public class Modul {

	private int modulPkid;
	private String modulName;
	private List<Menu> menuList;

	public Modul() {
		super();
		this.menuList = new ArrayList<Menu>();
	}

	public Modul(int modulPkid, String modulName, List<Menu> menuList) {
		super();
		this.modulPkid = modulPkid;
		this.modulName = modulName;
		this.menuList = menuList;
	}
	
	public Modul(int modulPkid, String modulName) {
		super();
		this.modulPkid = modulPkid;
		this.modulName = modulName;
		this.menuList = new ArrayList<Menu>();
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public String getModulName() {
		return modulName;
	}

	public void setModulName(String modulName) {
		this.modulName = modulName;
	}

	public int getModulPkid() {
		return modulPkid;
	}

	public void setModulPkid(int modulPkid) {
		this.modulPkid = modulPkid;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}	
}
