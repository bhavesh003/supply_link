export class Warehouse {
  warehouseId: number;
  supplierId: string;
  warehouseName: string;
  location: string;
  capacity: number;

  constructor(
    warehouseId: number,
    supplier: string,
    warehouseName: string,
    location: string,
    capacity: number
  ) {
    this.warehouseId = warehouseId;
    this.supplierId = supplier;
    this.warehouseName = warehouseName;
    this.location = location;
    this.capacity = capacity;
  }

  // displayInfo() {
  //   // Exact labels required by tests
  //   console.log(`Warehouse ID: ${this.warehouseId}`);
  //   console.log(`Supplier ID: ${this.supplierId}`);
  //   console.log(`Capacity: ${this.capacity}`);
  // }
}