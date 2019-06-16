import java.util.Collection;
import java.util.HashSet;

public class GenericTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Garment g1 = new Garment("Silk", 2);
		Garment g2 = new Garment("Cotton", 3);
		Garment g3 = new Garment("Ploy", 4);
		
		Cupboard<Garment> cupboard1 = new Cupboard<Garment>();
		Cupboard<Garment> cupboard2 = new Cupboard<Garment>();
		
		cupboard1.addItem(g1);
		cupboard1.addItem(g2);
		
		cupboard2.addItem(g1);
		cupboard2.addItem(g2);
		
		System.out.println(cupboard1.equals(cupboard2));
		
		cupboard2.addItem(g3);
		
		System.out.println(cupboard1.items.size());

		System.out.println(cupboard2.items.size());
		
		System.out.println(cupboard1.equals(cupboard2));
		System.out.println(cupboard1.compareTo(cupboard2));
	}
}

class Garment{
	String fabric;
	int size;
	
	public Garment(String fabric, int size) {
		super();
		this.fabric = fabric;
		this.size = size;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabric == null) ? 0 : fabric.hashCode());
		result = prime * result + size;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garment other = (Garment) obj;
		if (fabric == null) {
			if (other.fabric != null)
				return false;
		} else if (!fabric.equals(other.fabric))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
}

class Cupboard<T> implements Comparable<Cupboard>{
	public HashSet<T> items;
	
	public Cupboard() {
		this.items = new HashSet<T>();
	}
	
	public Cupboard(Collection collection) {
		this.items = new HashSet<T>(collection);
	}
	
	public HashSet<T> getItems() {
		return items;
	}

	public void setItems(HashSet<T> items) {
		this.items = items;
	}
	
	public void addItem(T t) {
		this.items.add(t);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupboard other = (Cupboard) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cupboard cupboard) {
		Integer size1 = (Integer)this.items.size();
		Integer size2 =  (Integer)cupboard.getItems().size();
		return size1.compareTo(size2);
	}
}
