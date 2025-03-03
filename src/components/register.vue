<template>
    <div class="d-flex justify-content-center align-items-center vh-150 bg-light">

    <div class="card p-4 shadow-lg rounded" style="width: 700px;">
        <h3 class="text-center mb-2">Đăng Kí</h3>
        <form @submit.prevent="guiForm">
            <!-- Họ và Tên -->
            <div class="mb-3">
                <label for="tenKhachHang" class="form-label">Họ và Tên</label>
                <input type="text" class="form-control" id="tenKhachHang" v-model="data.tenKhachHang" required>
            </div>

            <!-- Giới Tính -->
            <div class="mb-3">
                <label class="form-label">Giới Tính</label>
                <div>
                    <input type="radio" name="gt" v-model="data.gioiTinh" value="true" checked>
                    <label for="nam">Nam</label>
                    <input type="radio" name="gt" v-model="data.gioiTinh" value="false">
                    <label for="nu">Nữ</label>
                </div>
            </div>

            <!-- Ngày Sinh -->
            <div class="mb-3">
                <label for="ngaySinh" class="form-label">Ngày Sinh</label>
                <input type="date" class="form-control" id="ngaySinh" v-model="data.ngaySinh" required>
            </div>

            <!-- Địa Chỉ -->
            <div class="mb-3">
                <label for="diaChi" class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" id="diaChi" v-model="data.diaChi" required>
            </div>

            <!-- Số Điện Thoại -->
            <div class="mb-3">
                <label for="sdt" class="form-label">Số Điện Thoại</label>
                <input type="tel" class="form-control" id="sdt" v-model="data.sdt" required>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" v-model="data.email" required>
            </div>

            <!-- Tài Khoản -->
            <div class="mb-3">
                <label for="taiKhoan" class="form-label">Tài Khoản</label>
                <input type="text" class="form-control" id="taiKhoan" v-model="data.taiKhoan" required>
            </div>

            <!-- Mật Khẩu -->
            <div class="mb-3">
                <label for="matKhau" class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" id="matKhau" v-model="data.matKhau" required>
            </div>

            <!-- Nút Gửi -->
            <button type="submit" class="btn btn-primary">Đăng Ký</button>
        </form>
    </div>
  </div>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { RouterLink } from 'vue-router';

const data = ref({
    tenKhachHang: '',
    gioiTinh: '',
    ngaySinh: '',
    diaChi: '',
    sdt: '',
    email: '',
    taiKhoan: '',
    matKhau: ''
}
)


 const guiForm = () =>{

    axios.post("http://localhost:8080/register",data.value,{
        headers:{
            'Content-Type': 'application/json'
        }
    }).then(Response =>{
       alert('Đăng kí thành công')
       window.location.href = "/login";
    }).catch()
 }

</script>