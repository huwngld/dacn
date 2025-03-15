<template>
<div class="container mt-5">
        <h2 class="mb-4 text-center">Tìm kiếm đơn hàng</h2>
    <form @submit.prevent="f">
    <div class="input-group flex-nowrap">
    <span class="input-group-text" id="addon-wrapping">Tìm Kiếm</span>
    <input type="text" class="form-control" placeholder="Nhập vào số điện thoại" aria-label="Username" aria-describedby="addon-wrapping" v-model="ttkh">
    </div>
    <button class="btn btn-success mt-3" style="width: 14%;">Gửi</button>
    </form>
<table class="table">
    
    <thead class="table-gray">
        <tr>
            <th>#</th>
            <th>Tên khách Hàng</th>
            <th>SDT</th>
            <th>Địa Chỉ</th>
            <th>Trạng thái</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Tổng tiền</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <template v-for="(dt,index1) in data" :key="dt.maHoaDon">
            <tr v-for="(sp, index) in dt.chiTietHoaDon" :key="`${dt.maHoaDon}-${sp.maSach}`">
                <template v-if="index === 0">
                    <td :rowspan="dt.chiTietHoaDon.length">{{ index1+1 }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.khachHang.tenKhachHang || "" }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.khachHang.sdt || "" }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.khachHang.diaChi || "" }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.trangThai }}</td>
                </template>
                <td>{{ sp.sach.tenSach || "" }}</td>
                <td>{{ sp.soLuong || "" }}</td>
                <td>{{ sp.donGia || "" }}</td>
                <td v-if="index === 0" :rowspan="dt.chiTietHoaDon.length">{{ dt.tongTien }}</td>
                <td v-if="index === 0" :rowspan="dt.chiTietHoaDon.length">
                </td>
            </tr>
        </template>
    </tbody>
</table>
    </div>
</template>

<script setup>
import axios from 'axios';
import { nextTick, onMounted, ref } from 'vue';
    let dl = JSON.parse(localStorage.getItem('dataKH'))?JSON.parse(localStorage.getItem('dataKH')).sdt:null
    let ttkh = ref(dl);
    console.log(ttkh);
    
    let data = ref()
     const f = () =>{
        axios.get(`http://localhost:8080/trang-thai-don-hang/${ttkh.value}`).then(Response => {
            // console.log(Response.data);
            data.value = Response.data
            console.log(data.value);
            nextTick();
        }).catch(()=>{
            window.location.href="/error"
        })
    }
</script>