'use strict';

let staticVariable = 0;

const modalAdd = document.querySelector('.modal_add');
const modalEdit = document.querySelector('.modal_edit');
const modalDelete = document.querySelector('.modal_delete');
const overlay = document.querySelector('.overlay');
//Selecting the buttons
const addBtn = document.querySelector('.add_btn');
const editBtn = document.querySelector('.edit_btn');
const deleteBtn = document.querySelector('.delete_btn');
const closeModalAddBtn = document.querySelector('.close-modal');
const cancelAddBtn = document.querySelector('.cancel-button');
const closeModalEditBtn = document.querySelector('.close-modal-edit');
const editCancelBtn = document.querySelector('.edit_cancel-button');
const closeModalDeleteBtn = document.querySelector('.close-modal-delete');
const deleteCancelBtn = document.querySelector('.cancel_delete_btn');
const invTable = document.querySelector('.invoice_table');
const deleteButton = document.querySelector('.delete_button');
//function to show the modal
const openAddModal = function () {
  modalAdd.classList.remove('hidden');
  overlay.classList.remove('hidden');
};
const openEditModal = function () {
  modalEdit.classList.remove('hidden');
  overlay.classList.remove('hidden');
};
const openDeleteModal = function () {
  modalDelete.classList.remove('hidden');
  overlay.classList.remove('hidden');
};

//function to close modal
const closeModal = function () {
  modalAdd.classList.add('hidden');
  modalEdit.classList.add('hidden');
  modalDelete.classList.add('hidden');
  overlay.classList.add('hidden');
  overlay.addEventListener('click', closeModal);
};
//Opening the Add MOdal
addBtn.addEventListener('click', openAddModal);
//Closing the add Modal
closeModalAddBtn.addEventListener('click', closeModal);
cancelAddBtn.addEventListener('click', closeModal);

//Opening the edit Modal
editBtn.addEventListener('click', openEditModal);
//Closing the add Modal
closeModalEditBtn.addEventListener('click', closeModal);
editCancelBtn.addEventListener('click', closeModal);

//Opening the delete Modal
deleteBtn.addEventListener('click', openDeleteModal);
//closing the delete modal
closeModalDeleteBtn.addEventListener('click', closeModal);
deleteCancelBtn.addEventListener('click', closeModal);
 
//Inserting into the table
const enterTableData = (data) => {
  const tableBody = document.getElementById('tablebody');

  let tabData = '';

  for (let row of data) {
    tabData += `<tr>
                    <td><img src="images/unchecked.jpeg" style="height:1.3rem ;" class="checkbox" alt="checkbox"></td>
                    <td class="align-right">${row.cus_name}</td>
                    <td class="align-right">${row.cus_no}</td>
                    <td class="align-right">${row.invoice_id}</td>
                    <td class="align-right">${row.invoice_amt}</td>
                    <td class="align-right">${row.due_date}</td>
                    <td class="align-right">${row.predict_date}</td> 
                    <td class="align-right">${row.notes}</td>
                </tr>`;
  }
  
  tableBody.innerHTML = tabData;

  document.querySelectorAll('tbody .checkbox').forEach(item => {
             item.addEventListener('click', event => {
             // addBtn.classList.remove('btn-disable');
                 if(item.src.includes('images/checked.jpeg'))
                 {
                     item.src='images/unchecked.jpeg';
                     staticVariable -= 1;
                     if(staticVariable===1){
                        
                        editBtn.classList.remove('btn-disable');
                        deleteBtn.classList.remove('btn-disable');
                        //addBtn.classList.add('btn-disable');
                     }

                     else if(staticVariable>1 || staticVariable ===0){
                        
                        editBtn.classList.add('btn-disable');
                         deleteBtn.classList.add('btn-disable');
                        // staticVariable ?  addBtn.classList.add('btn-disable') : addBtn.classList.remove('btn-disable');
                     }
                     
                    console.log(staticVariable);
                    //console.log(item.parentElement.parentElement.rowIndex);
                 }
                        
                     else
                       {
                            item.src='images/checked.jpeg';
                            staticVariable += 1;

                            if(staticVariable===1){
                                
                                editBtn.classList.remove('btn-disable');
                                deleteBtn.classList.remove('btn-disable');
                                // addBtn.classList.add('btn-disable');
                             }
        
                             else if(staticVariable===0 || staticVariable >1){
                                
                                editBtn.classList.add('btn-disable');
                                 deleteBtn.classList.add('btn-disable');
                                // staticVariable ?  addBtn.classList.add('btn-disable') : addBtn.classList.remove('btn-disable');
                             }
                             
                       }
                   
             })
           });
   
  };
 /* const tbdy = document.getElementById('tablebody');
  let rIndex = 0;
                   for(let i=0; i<tbdy.rows.length;i++)
                   {
                   for(let j=0;j<tbdy.rows[i].cells.length;j++)
                   {
                     tbdy.rows[i].cells[j].onclick = function()
                     {
                       rIndex = this.parentElement.rowIndex;
                       console.log(rIndex);
                     };
                     }
                    }
*/
//Fetching the json from back end
const getJsonData = () => {
  fetch('http://localhost:8080/H2HBABBA2668/fetchData')
    .then(res => {
      return res.json();
    })
    .then(data => {
      enterTableData(data);
      //console.log(data);
    })
    .catch(err => {
      console.log('ERROR', err);
      enterTableData([]);
    });
};
getJsonData();

//function to select all checkbox
document.getElementById('select-all').onclick = function() {
    var checkboxes = document.getElementsByClassName('checkbox');

 
    for (var checkbox of checkboxes) {
        // checkbox.src = this.checked;
      if(checkbox.src.includes('images/unchecked.jpeg'))
        checkbox.src='images/checked.jpeg';
    else
       checkbox.src='images/unchecked.jpeg';
    }
}


//EDIT
document.querySelector('.edit_btn').addEventListener('click',(event)=>{

    
     let invid=document.querySelector("tbody tr img[src='images/checked.jpeg']").parentElement.nextElementSibling.nextElementSibling.nextElementSibling.innerText;
     

     document.getElementById('inid').value=invid;
});





//DELETE
deleteBtn.addEventListener('click',(event)=>{

    
     let invid1=document.querySelector("tbody tr img[src='images/checked.jpeg']").parentElement.nextElementSibling.nextElementSibling.nextElementSibling.innerText;
     

     document.getElementById('inid1').value=invid1;
});