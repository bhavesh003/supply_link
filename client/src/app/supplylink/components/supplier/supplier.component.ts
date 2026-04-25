import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Supplier } from '../../types/Supplier';
import { Component } from '@angular/core';

@Component({
    selector: 'supplier-component',
    imports: [ReactiveFormsModule],
    template: '<label for = "name">Name: </label> <input id = "name" type = "text" [(ngModel)] = "supplierForm.supplierName"/><label for = "email">Email:</label><input id = "email" type = "text" [(ngModel)] = "supplierForm.email"/><label for = "username">Username:</label><input id = "text" type = "text" [(ngModel)] = "supplierForm.username" /><label for = "password">Password:</label><input id = "password" type = "password" [(ngModel)] = "supplierForm.password"/><btn onclick() = "onSubmit()">Submit</bt> '
})
export class SupplierComponent {

    supplierForm = new Supplier(1, "", "", "", "", "", "", "");
    ngOninit() {

    }
}