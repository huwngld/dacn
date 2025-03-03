<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';
import router from '@/router/router';
import { useRoute } from 'vue-router';

const route = useRoute();
const id = route.params.id;
let data = ref(null)
  onMounted(() =>{    
  axios.get(`http://localhost:8080/sach/details/${id}`).then(Response =>{
   data.value = Response.data.result;
  })
}
)

     const goToResult = (id) => {
    router.push({ name: 'ResultPage1', params: { ma: id } });
};
</script>
<template>
     <div class="container mt-5 mb-5">
    <div class="row">
      <!-- Ảnh sản phẩm -->
      <div class="col-md-5">
        <img :src="data.img" class="img-fluid main-img" alt="Sản phẩm" v-if="data">
        <div class="d-flex mt-3">
        </div>
      </div>

      
      <div class="col-md-7">
        <h4>Thông tin chi tiết</h4>
        <table class="table">
          <tbody>
            <tr>
              <td><strong>Tên Sách</strong></td>
              <td v-if="data">{{ data.tenSach }}</td>
            </tr>
            <tr>
              <td><strong>Tác giả</strong></td>
              <td v-if="data">{{ data.tacGia.tenTacGia }}</td>
            </tr>
            <tr>
              <td><strong>Thể Loại</strong></td>
              <td v-if="data">{{ data.theLoai.tenTheLoai }}</td>
            </tr>
            <tr>
              <td><strong>Nhà xuất bản</strong></td>
              <td v-if="data">{{ data.nhaXuatBan.tenNhaXuatBan }}</td>
            </tr>
            <tr>
              <td><strong>Số lượng tồn</strong></td>
              <td v-if="data">{{ data.soLuongTon }}</td>
            </tr>
            
          </tbody>
        </table>
        Giá Bán: <div class="fs-2 text-danger fw-bolder" v-if="data">{{ data.giaBan }} đ</div><br>
        <button class="btn btn-success mt-3" @click="goToResult(data.maSach)"> Mua Ngay</button>
        <button class="btn btn-outline-danger ms-5 mt-3">Thêm vào giỏ hàng</button>
      </div>
    </div>
  </div>
</template>
