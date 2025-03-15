<template>
    <div class="container mt-5">
        <h2 class="mb-4 text-center">Lịch sử Đặt Hàng</h2>
        <table class="table">
    <thead class="table-gray">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Khách hàng</th>
            <th>Số điện thoại</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
            <th>Tên sách</th>
            <th>Số lượng tồn</th>
            <th>Số lượng</th>

        </tr>
    </thead>
    <tbody>
        <template v-for="dt in data" :key="dt.maHoaDon">
            <tr v-for="(sp, index) in dt.chiTietHoaDon" :key="`${dt.maHoaDon}-${sp.maSanPham}`">
                <template v-if="index === 0">
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.maHoaDon }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.khachHang ? dt.khachHang.tenKhachHang : "" }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.khachHang ? dt.khachHang.sdt: "" }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.tongTien }}</td>
                    <td :rowspan="dt.chiTietHoaDon.length">{{ dt.trangThai }}</td>
                </template>
                <td>{{ sp.sach ? sp.sach.tenSach : "" }}</td>
                <td>{{ sp.sach ? sp.sach.soLuongTon : "" }}</td>
                <td>{{ sp ? sp.soLuong : "" }}</td>
            </tr>
        </template>
    </tbody>
</table>
    </div>
</template>
<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';
    let data = ref()
    onMounted( ()=>{
        if(localStorage.getItem("token") === null){
            window.location.href = "/"
        }
        let token = JSON.parse(localStorage.getItem("token"))
        axios.get("http://localhost:8080/admin/lich-su-dat-hang",{
        headers:{
            Authorization: `Bearer ${token}`
        }
     })
    .then(Response =>{
        data.value = Response.data
        console.log(data.value);   
    }).catch(()=>{
            window.location.href="/error"
        })    
    })
</script>