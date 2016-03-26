
public class FlowShape {

	
	private String name;
	private String shape;
	private FlowShape next;
	private FlowShape next2;
	private FlowShape prev;
	private int positionX;
	private int positionY;
	/**
	 * Has all the data about the flowchart states 
	 * @param name
	 * 
	 */
	
	public FlowShape(String name)
	{
		this.setName(name);
		this.setShape("");
		this.setNext(null);
		this.setPrev(null);
		this.setNext2(null);
		this.setPositionX(0);
		this.setPositionY(0);
	}
	
	/**
	 * @return the name of FlowShape
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name for the FlowShape
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the x position
	 */
	public int getPositionX() {
		return positionX;
	}

	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}


	public String getShape() {
		return shape;
	}

	
	public void setShape(String shape) {
		this.shape = shape;
	}

	
	public FlowShape getNext() {
		return next;
	}

	/**
	 * Sets the FlowShape that follows this one
	 * @param next
	 */
	public void setNext(FlowShape next) {
		this.next = next;
	}


	public FlowShape getNext2() {
		return next2;
	}

	/**
	 * Sets the FlowShape that follows this one in the case of no branch in if
	 * @param next
	 */
	public void setNext2(FlowShape next2) {
		this.next2 = next2;
	}

	
	public FlowShape getPrev() {
		return prev;
	}

	/**
	 * Sets the FlowShape that goes before this one
	 * @param prev
	 */
	public void setPrev(FlowShape prev) {
		this.prev = prev;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof FlowShape&&((FlowShape)obj).getName().equals(this.getName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	
	
	
}
