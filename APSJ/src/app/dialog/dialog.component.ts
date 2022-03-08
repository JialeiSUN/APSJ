import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validator, Validators } from '@angular/forms';
import { CrudService } from '../crud.service';
import{MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog'
@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
  categorieList = ["PC_Portable", "Accessoires_ordinateurs","PC_de_Bureau",
  "Smart_phone","Tel_Fixe","Accessoires_téléphone",
  "Disque_dur","Clé_USB","Accessoires_stockage"];
  productForm !: FormGroup;
  actionBtn : string = "Save"
  constructor(
    private formBuilder: FormBuilder, 
    private api : CrudService,
    @Inject(MAT_DIALOG_DATA) public editData : any,
    private dialogRef: MatDialogRef<DialogComponent>) { }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      libelle:['',Validators.required],
      categorie:['',Validators.required],
      prix:['',Validators.required],
      marque:['',Validators.required]
    });
    if(this.editData){
      this.actionBtn = "Update"
      this.productForm.controls['libelle'].setValue(this.editData.libelle)
      this.productForm.controls['categorie'].setValue(this.editData.categorie)
      this.productForm.controls['prix'].setValue(this.editData.prix)
      this.productForm.controls['marque'].setValue(this.editData.marque)

    }

  }
  addProduct(){
    if(!this.editData){
      if(this.productForm.valid){
        this.api.postProduct(this.productForm.value).subscribe({
          next:(res)=>{
            alert("Product added successfully");
            this.productForm.reset();
            this.dialogRef.close();
          },
          error:()=>{
            alert("Error while adding the product");
          }
        })
      }
    }
    else{
      this.updateProduct()
    }
  }
  updateProduct(){
    this.api.putProduct(this.productForm.value, this.editData.id_a)
    .subscribe({
      next:(res)=>{
        alert("Product updated Successfully");
        this.productForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("Error while updating");
      }
    })
  }
}
