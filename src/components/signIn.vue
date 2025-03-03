<template>
  <div class="d-flex justify-content-center align-items-center vh-100 bg-light">

    <div class="card p-4 shadow-lg rounded" style="width: 350px;">
        <h3 class="text-center mb-4">Đăng nhập</h3>
        <form @submit.prevent="submitForm">
            <div class="mb-3">
                <label for="email" class="form-label">Tài Khoản</label>
                <input type="text" class="form-control" id="email" placeholder="Tài Khoản" v-model="formData.taiKhoan" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password" placeholder="Nhập mật khẩu" v-model="formData.matKhau" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>
        <div class="text-center mt-3">
            <a href="/register" class="text-decoration-none">Đăng kí ngay</a>
        </div>
    </div>
  </div>
</template>


<script setup>

import { ref } from 'vue';
import axios from 'axios';

const formData = ref({
  taiKhoan: '',
  matKhau: ''
})

// Hàm submit form
const submitForm = () => {
  axios.post('http://localhost:8080/sign-in',formData.value,{
     headers: {
        'Content-Type': 'application/json'
    }
  })
    .then(response => { 
       if(response.data.trangThai){
        alert('thanh cong')
        localStorage.clear
        localStorage.setItem("dataKH",JSON.stringify(response.data.result))
        let dataKH = JSON.parse(localStorage.getItem('dataKH'));
        window.location.href = "/"
       }else{
        alert('sai tk mk')
       }
    })
    .catch(error => {
      console.error('Lỗi khi gửi dữ liệu:', error)
    })
}
     
</script>