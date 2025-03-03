<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter(); // Đặt ở đầu


    let data = ref({
        
    })
    axios.get("http://localhost:8080/").then(Response => {
        data.value = Response.data.result
    console.log(data.value)
    })

     const goToResult = (id) => {
    router.push({ name: 'ResultPage', params: { id: id } });
}; 
</script>
<template>
<head>
    <title>Trang Chủ - Shop Online</title>
    
</head>
    <!-- Banner -->
    <div class="container mt-4">
        <div class="p-5 text-center bg-light rounded">
            <h1>Chào mừng bạn đến với Shop Online</h1>
            <p class="lead">Mua sắm dễ dàng, nhanh chóng và tiện lợi</p>
        </div>
    </div>

    <!-- Danh mục sản phẩm -->
    <div class="container mt-4">
        <h2 class="text-center mb-4">Danh Mục Sản Phẩm</h2>
        <div class="row text-center">
            <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="10000">
      <img src="http://localhost:8080/uploads/banner2.webp" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="http://localhost:8080/uploads/banner1.webp" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="http://localhost:8080/uploads/banner3.webp" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
        </div>
    </div>

    <!-- Sản phẩm nổi bật -->
    <div class="container mt-4">
        <h2 class="text-center mb-4">Sản Phẩm Nổi Bật</h2>
        <div class="row">
            <div class="col-md-4 me-4 mb-3" v-for="list in data">
                <div class="card"  >
                    <img :src="list.img" class="card-img-top" alt="Sản phẩm 1">
                    <div class="card-body">
                        <h5 class="card-title">{{ list.tenSach }}</h5>
                        <p class="card-text">{{ list.theLoai.tenTheLoai }}</p>
                        <p class="card-text">{{ list.nhaXuatBan.tenNhaXuatBan }}</p>
                        <p class="card-text text-danger fs-3 fw-bolder">{{ list.giaBan }} đ</p>
                        <a @click="goToResult(list.maSach)" class="btn btn-primary">Mua ngay</a>
                        <a href="#" class="btn btn-outline-success ms-5">Thêm Vào Giỏ Hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>