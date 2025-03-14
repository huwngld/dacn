<script setup>
    import axios, { getAdapter } from 'axios';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';


const randomNumber = Math.floor(Math.random() * 1000) + 1;   
let gioHang = JSON.parse(localStorage.getItem("gioHang"));
let login = ref(false)
if(JSON.parse(localStorage.getItem('dataKH'))!==null){
    login.value = true
}else{
    login.value = false
}


let dataKH = JSON.parse(localStorage.getItem('dataKH'))


let qrcode=ref({
    gt:""
})


let getData =ref({
    giaBan: 0
    }
)
for(let i = 0;i<gioHang.length;i++){
    getData.value.giaBan = getData.value.giaBan +gioHang[i].amount;
}

let ttkh = ref({
    orderCode: randomNumber,
    amount: getData.value.giaBan,
    description: "",
    taiKhoan: dataKH!==null?dataKH.taiKhoan:"",
    buyerName: dataKH!==null?dataKH.tenKhachHang:"",
    buyerPhone:  dataKH!==null?dataKH.tenKhachHang:"",
    buyerAddress:  dataKH!==null?dataKH.tenKhachHang:"",
    items: gioHang,
    cancelUrl: "http://localhost:5173/that-bai",
    returnUrl: "http://localhost:5173/thanh-cong",
    signature: ""
})
let dl = ref({
    data: "1",
})
let f = ref()
    
    const callApi = async() =>{        
        ttkh.value.amount = getData.value.giaBan
        console.log(ttkh.value);
        dl.value.data = "{'amount':"+ttkh.value.amount+",'cancelUrl':'"+ ttkh.value.cancelUrl+"','description':'"+ttkh.value.description +"','orderCode':"+ randomNumber +",'returnUrl':'"+ ttkh.value.returnUrl+"'}"
    await axios.post("http://localhost:8080/convert",dl.value,{
         headers:{
             "Content-Type": "application/json"
         }
     }).then(Response =>{
       ttkh.value.signature = Response.data 
     })
        call()
    
    }
    


const call = () =>{
    axios.post("https://api-merchant.payos.vn/v2/payment-requests",ttkh.value,{
        headers:{
            "Content-Type": "application/json",
            "x-client-id": "0e92cf06-3fe2-4e62-b56c-691c19251a35", 
            "x-api-key": "2dcc721a-fa13-4ff6-80ca-7b6b89a81749"
        }
    }).then(Response =>{
        localStorage.setItem("ttkh",JSON.stringify(ttkh.value))
        console.log(JSON.parse(localStorage.getItem("ttkh")));
        // window.location.href = "/thanh-cong"
        window.location.href = Response.data.data.checkoutUrl
    })
}
const test =async ()=>{
    if(qrcode.value.gt === 'true'){
        ttkh.value.orderCode = null;
        localStorage.setItem("ttkh",JSON.stringify(ttkh.value))
        window.location.href='/thanh-cong'
        return
    }
    if(qrcode.value.gt === 'false'){
        callApi()
        return
    }
   
}
</script>

<template>
    <div class="d-flex justify-content-center align-items-center vh-150 bg-light">

    <div class="card p-4 shadow-lg rounded" style="width: 700px;">
        <h3 class="text-center mb-2">Đăng Kí</h3>
        <form @submit.prevent="test">
            <!-- Họ và Tên -->
            <div class="mb-3">
                <label for="tenKhachHang" class="form-label">Họ và Tên</label>
                <input type="text" class="form-control" id="tenKhachHang" v-model="ttkh.buyerName" required>
            </div>
            <!-- Địa Chỉ -->
            <div class="mb-3">
                <label for="diaChi" class="form-label">Địa Chỉ</label>
                <input type="text" class="form-control" id="diaChi" v-model="ttkh.buyerAddress" required>
            </div>

            <!-- Số Điện Thoại -->
            <div class="mb-3">
                <label for="sdt" class="form-label">Số Điện Thoại</label>
                <input type="tel" class="form-control" id="sdt" v-model="ttkh.buyerPhone" required>
            </div>

            <div class="mb-3">
                <label for="ghiChu" class="form-label">Ghi Chú</label>
                <input type="tel" class="form-control" id="ghiChu" v-model="ttkh.description" required>
            </div>
            <div>
                <label name="form-label" for="tts">Thanh Toán Khi Nhận Hàng</label>
                <input type="radio" class="form-check-input" id="tts" v-model="qrcode.gt" value="true"><br>
                <label name="form-label" for="qr">Thanh Toán Bằng QR Code</label>
                <input type="radio" class="form-check-input" name="qrcode" v-model="qrcode.gt" value="false" id="qr">
            </div>
            <!-- Nút Gửi -->
            <button type="submit" class="btn btn-primary">Mua Hàng</button>
        </form>
    </div>
  </div>
</template>