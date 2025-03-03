<script setup>
    import axios from 'axios';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const id = route.params.ma;
console.log(id);

const ttkh = ref({
    idSach: id,
    ten: "",
    diaChi: "",
    sdt: ""
})

const call = () =>{
    axios.post("http://localhost:8080/mua-hang",ttkh.value,{
        headers:{
            "Content-Type": "application/json"
        }
    }).then(Response =>{
        console.log(Response.data);
        
    })
}
</script>

<template>
    <div class="d-flex justify-content-center align-items-center vh-150 bg-light">

    <div class="card p-4 shadow-lg rounded" style="width: 700px;">
        <h3 class="text-center mb-2">Đăng Kí</h3>
        <form @submit.prevent="call">
            <!-- Họ và Tên -->
            <div class="mb-3">
                <label for="tenKhachHang" class="form-label">Họ và Tên</label>
                <input type="text" class="form-control" id="tenKhachHang" v-model="ttkh.ten" required>
            </div>
            <!-- Địa Chỉ -->
            <div class="mb-3">
                <label for="diaChi" class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" id="diaChi" v-model="ttkh.diaChi" required>
            </div>

            <!-- Số Điện Thoại -->
            <div class="mb-3">
                <label for="sdt" class="form-label">Số Điện Thoại</label>
                <input type="tel" class="form-control" id="sdt" v-model="ttkh.sdt" required>
            </div>
            <!-- Nút Gửi -->
            <button type="submit" class="btn btn-primary">Đăng Ký</button>
        </form>
    </div>
  </div>
</template>