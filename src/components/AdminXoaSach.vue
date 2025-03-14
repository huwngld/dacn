<template>
    <table class="table ms-5 me-5">
        <thead>
        <tr>
            <th scope="col">Tên Sách</th>
            <th scope="col">Tác giả</th>
            <th scope="col">thể loại</th>
            <th scope="col">số lượng tồn</th>
            <th scope="col">nhà xuất bản</th>
            <th scope="col">giá bán</th>
        </tr>
        </thead>
        <tbody>
            <tr v-for="dt in data">
                <td>{{ dt.tenSach }}</td>
                <td>{{ dt.tacGia.tenTacGia }}</td>
                <td>{{ dt.theLoai.tenTheLoai }}</td>
                <td>{{ dt.soLuongTon }}</td>
                <td>{{ dt.nhaXuatBan.tenNhaXuatBan }}</td>
                <td>{{ dt.giaBan }}</td>
                <td><button @click="xoa(dt.maSach)">Xóa</button></td>
            </tr>
        </tbody>
    </table>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';
let token = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJodW5nIiwic3ViIjoiYWRtaW4xIiwic2NvcGUiOiJTVEFGRiJ9.qjwv_mj4-b28Hv4utFBC_1ZyGk0fudummg2bdisH2zcOXQEdgC29MAXtOkH1dtpRu8QXbKe_U1BgIVVogwIB5w"
let data=ref()
    axios.get("http://localhost:8080/admin/sach",{
        headers:{
            Authorization:`Bearer ${token}`
        }
    }).then(Response=>{
        data.value  = Response.data.result
        console.log(data.value);
    })

function xoa(index){
    console.log(index);
    
    axios.get(`http://localhost:8080/admin/delete/${index}`,{
        headers:{
            Authorization:`Bearer ${token}`
        }
    }).then(Response=>{
        data.value  = Response.data.result
        console.log(data.value);
    })
}
</script>