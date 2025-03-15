<template>
<div class="container mt-5">
        <h2 class="mb-4 text-center">Lịch sử Đặt Hàng</h2>
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
            <tr v-for="(sp, index) in dt.items" :key="`${dt.maHoaDon}-${sp.maSach}`">
                <template v-if="index === 0">
                    <td :rowspan="dt.items.length">{{ index1+1 }}</td>
                    <td :rowspan="dt.items.length">{{ dt.tenKhachHang || "" }}</td>
                    <td :rowspan="dt.items.length">{{ dt.sdt || "" }}</td>
                    <td :rowspan="dt.items.length">{{ dt.diaChi || "" }}</td>
                    <td :rowspan="dt.items.length">{{ dt.trangThai }}</td>
                </template>
                <td>{{ sp.ten || "" }}</td>
                <td>{{ sp.soLuong || "" }}</td>
                <td>{{ sp.gia || "" }}</td>
                <td v-if="index === 0" :rowspan="dt.items.length">{{ dt.tongTien }}</td>
                <td v-if="index === 0" :rowspan="dt.items.length">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-info" @click="viewOrder(index1)">
                            xac-nhan-don-hang
                        </button>
                        <button type="button" class="btn btn-sm btn-danger" @click="deleteOrder(index1)">
                            huy
                        </button>
                    </div>
                </td>
            </tr>
        </template>
    </tbody>
</table>
    </div>
</template>

<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';

    let token = JSON.parse(localStorage.getItem("token"))
    let data = ref()
    onMounted( ()=>{
        if(localStorage.getItem("token") === null){
            window.location.href = "/"
        }
        axios.get("http://localhost:8080/admin/xac-nhan-don-hang",{
            headers:{
                Authorization: `Bearer ${token}`
            }
        }).then(Response =>{
        data.value = Response.data
         console.log(Response.data);
        }).catch(()=>{
            window.location.href="/error"
        })
    })

    function viewOrder (index1){
    axios.get(`http://localhost:8080/admin/save-data/${index1}`,{
            headers:{
                Authorization: `Bearer ${token}`
            }
        }).then(Response =>{
        console.log(Response.data);
    }).catch(()=>{
            window.location.href="/error"
        })
    deleteOrder(index1)
}
function deleteOrder(index1){
    axios.get(`http://localhost:8080/admin/huy-don-hang/${index1}`,{
            headers:{
                Authorization: `Bearer ${token}`
            }
        }).then(Response =>{
        console.log(Response.data);
    }).catch(()=>{
            window.location.href="/error"
        })
    location.reload(true);
}

</script>