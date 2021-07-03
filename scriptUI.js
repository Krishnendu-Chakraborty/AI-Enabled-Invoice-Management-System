'use strict';
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
