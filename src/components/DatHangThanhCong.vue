<template>
<div class="container text-center" style="margin-top: 10%; margin-bottom: 10%;">
    <div class="card shadow-lg p-4">
        <div class="card-body">
            <div class="text-success">
                <svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 8 0a8 8 0 0 1 8 8ZM6.93 10.58l4.48-4.48a.5.5 0 0 0-.707-.707L6.5 9.086 4.777 7.364a.5.5 0 1 0-.707.707l2.5 2.5a.5.5 0 0 0 .707 0Z"/>
                </svg>
            </div>
            <h2 class="mt-3 text-success">Đặt Hàng Thành Công!</h2>
            <p class="text-muted">Cảm ơn bạn đã mua hàng. Đơn hàng của bạn đã được xác nhận.</p>

            <div class="mt-4">
                <a href="/" class="btn btn-primary">Quay lại trang chủ</a>
            </div>
        </div>
    </div>
</div>

</template>
<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';

    let data = JSON.parse(localStorage.getItem('ttkh'))
    console.log(data);
    let status = ref("PENDING")
    let orderCode = JSON.parse(localStorage.getItem('ttkh'))?JSON.parse(localStorage.getItem('ttkh')).orderCode:""
    let ttkh =ref({
        taiKhoan: data.taiKhoan,
        tenKhachHang: data.buyerName,
        tongTien: data.amount,
        diaChi: data.buyerAddress,
        sdt: data.buyerPhone,
        ghiChu: data.description,
        items: data.items.map(item => ({
        maSach: item.maSach,
        ten: item.name,
        gia: item.price,
        soLuong: item.quantity
        })),
        trangThai: "PENDING"
    })
    onMounted( async()=>{ 
       if(orderCode!=null) {
       
        await axios.get(`https://api-merchant.payos.vn/v2/payment-requests/${orderCode}`,{
             headers:{
            "x-client-id": "0e92cf06-3fe2-4e62-b56c-691c19251a35", 
            "x-api-key": "2dcc721a-fa13-4ff6-80ca-7b6b89a81749"
            }
        }).then(Response =>(
            status.value = Response.data.data.status,
            ttkh.value.trangThai = Response.data.data.status
        )).catch(()=>{
            window.location.href="/error"
        })    
       }
       if(status.value !== 'CANCELLED'){
            axios.post("http://localhost:8080/admin/luu-don-hang",ttkh.value,{
                headers:{
                    "Content-Type": "application/json"
                }
            }).then(Response=>{
                console.log(Response.data);
                
            }).catch(()=>{
            window.location.href="/error"
        })
        }
    })
    
</script>