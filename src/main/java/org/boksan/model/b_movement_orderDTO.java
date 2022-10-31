package org.boksan.model;

public class b_movement_orderDTO {
	
	private String pallet_num;
	
	private String movement_address;

	public String getPallet_num() {
		return pallet_num;
	}

	public void setPallet_num(String pallet_num) {
		this.pallet_num = pallet_num;
	}

	public String getMovement_address() {
		return movement_address;
	}

	public void setMovement_address(String movement_address) {
		this.movement_address = movement_address;
	}

	@Override
	public String toString() {
		return "b_movement_orderDTO [pallet_num=" + pallet_num + ", movement_address=" + movement_address + "]";
	}
}
