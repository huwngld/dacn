<template>

<nav class="navbar navbar-expand-lg navbar-dark bg-danger mb-3">
        <div class="container">
            <RouterLink to="/" class="nav-link text-white text-decoration-none">Shop Online</RouterLink>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">

                    <li class="nav-item text-white mt-2" v-if="data!=null">Xin Chào: {{ data.tenKhachHang }}</li>
                    <li class="nav-item"><RouterLink to="/" class="nav-link text-white text-decoration-none">Home</RouterLink></li>
                    <li class="nav-item"><RouterLink to="/login" class="nav-link text-white">Login</RouterLink></li>
                    <li class="nav-item"><RouterLink to="/register" class="nav-link text-white">Register</RouterLink></li>

                    <li class="nav-item text-white mt-2" @click="logout" ><a href="" class="text-white text-decoration-none">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
<RouterView></RouterView>
<footer class="bg-dark text-white text-center py-3 mt-4">
        &copy; 2025 Shop Online. All rights reserved.
    </footer>
</template>
<script setup>
import DangNhap from './components/register.vue';
import Home from './components/Home.vue';
import Sach from './components/Sach.vue';
import SignIn from './components/signIn.vue';
import { onMounted, ref } from 'vue';
let data = ref()
onMounted(()=>{
   if(localStorage.getItem('dataKH')!= null){
    data.value = JSON.parse(localStorage.getItem('dataKH'));
    console.log(data.value)
   }
})

const logout = () =>{
    localStorage.removeItem("dataKH")
    window.location.href = "/"
}

</script>