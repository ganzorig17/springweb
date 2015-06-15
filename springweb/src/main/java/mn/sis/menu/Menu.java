package mn.sis.menu;

public class Menu {
	private int menuPkId;
	private String menuName;
	private String tileName;
	
	
	public Menu() {
		super();
	}
	public Menu(int menuPkId, String menuName, String tileName) {
		super();
		this.menuPkId = menuPkId;
		this.menuName = menuName;
		this.tileName = tileName;
	}
	public int getMenuPkId() {
		return menuPkId;
	}
	public void setMenuPkId(int menuPkId) {
		this.menuPkId = menuPkId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getTileName() {
		return tileName;
	}
	public void setTileName(String tileName) {
		this.tileName = tileName;
	}
	
}
