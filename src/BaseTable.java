public abstract class BaseTable {
	private String primaryKey;
	
	public BaseTable(String primaryKey) {
		setPrimaryKey(primaryKey);
	}
	
	// start of a set and get methods block
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public String getPrimaryKey() {
		return this.primaryKey;
	}
	//	end of a set and get methods block
}
