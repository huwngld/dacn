<template >
<div class="d-flex flex-column min-vh-100">
    <div class="flex-grow-1">
<nav class="navbar navbar-expand-lg navbar-dark bg-danger mb-3">
        <div class="container" v-if="token==null">
            <RouterLink to="/" class="nav-link text-white text-decoration-none">Shop Online</RouterLink>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><RouterLink to="/gio-hang" class="nav-link text-white text-decoration-none">Giỏ hàng</RouterLink></li>
                    <li class="nav-item text-white mt-2" v-if="data!=null">Xin Chào: {{ data.tenKhachHang }}</li>
                    <li class="nav-item text-white mt-2" v-if="token!=null">Xin Chào: admin</li>
                    <li class="nav-item"><RouterLink to="/" class="nav-link text-white text-decoration-none">Home</RouterLink></li>
                    <li class="nav-item" v-if="data==null"><RouterLink to="/login" class="nav-link text-white">Login</RouterLink></li>
                    <li class="nav-item" v-if="data==null"><RouterLink to="/register" class="nav-link text-white">Register</RouterLink></li>
                    <li class="nav-item text-white mt-2" v-if="data!=null"><a href="/" class="text-white text-decoration-none" @click="logout">Logout</a></li>
                </ul>
            </div>
        </div>

        <div class="container" v-if="token!=null">
            <RouterLink to="/" class="nav-link text-white text-decoration-none">Shop Online</RouterLink>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item text-white mt-2" v-if="token!=null">Xin Chào: admin</li>
                    <li class="nav-item"><RouterLink to="/them-sach" class="nav-link text-white">Thêm Sách</RouterLink></li>
                    <li class="nav-item"><RouterLink to="/hien-thi" class="nav-link text-white">Xóa sách</RouterLink></li>
                    <li class="nav-item"><RouterLink to="/xac-nhan-don-hang" class="nav-link text-white text-decoration-none">Xác nhận đơn hàng</RouterLink></li>
                    <li class="nav-item"><RouterLink to="/lich-su-dat-hang" class="nav-link text-white">Lịch sử đặt hàng</RouterLink></li>
                    
                    <li class="nav-item text-white mt-2" ><a href="/" class="text-white text-decoration-none" @click="logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
<RouterView></RouterView>
</div>

    <footer  class="mt-auto bg-dark text-white text-center py-3">
        &copy; 2025 Shop Online. All rights reserved.
    </footer>
    </div>

</template>
<script setup>
import DangNhap from './components/register.vue';
import Home from './components/Home.vue';
import Sach from './components/Sach.vue';
import SignIn from './components/signIn.vue';
import { onMounted, ref } from 'vue';
let data = ref()
let token = ref()
onMounted(()=>{
   if(localStorage.getItem('dataKH')!= null){
    data.value = JSON.parse(localStorage.getItem('dataKH'));
    console.log(data.value)
   }
   if(localStorage.getItem("token")!== null){
    token.value = localStorage.getItem("token")
   }
})

const logout = () =>{
    localStorage.clear()
}


</script>