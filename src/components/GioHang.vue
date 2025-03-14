<template>
  <div class="container mt-5">
    <h2 class="mb-4">🛒 Giỏ Hàng</h2>

    <table class="table table-bordered">
      <thead>
        <tr class="table-primary">
          <th>#</th>
          <th>Tên Sách</th>
          <th>Giá</th>
          <th>Số lượng</th>
          <th>Hành động</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(ds,index) in gioHang" :key="ds.id">
          <td>{{ ds.maSach }}</td>
          <td>{{ ds.name }}</td>
          <td>{{ ds.price }}</td>
          <td>
            <button class="btn btn-sm btn-primary" @click="changeQuantity(index, -1)">-</button>
            <span class="mx-2">{{ ds.quantity }}</span>
            <button class="btn btn-sm btn-primary" @click="changeQuantity(index, 1)">+</button>
          </td>
          <td>
            <button class="btn btn-sm btn-danger" @click="removeProduct(index)">🗑 Xóa</button>
          </td>
        </tr>
      </tbody>
    </table>
   <button @click="click">Thanh Toan</button>
    <h4 class="mt-3">Tổng tiền: {{ tongTien.toLocaleString() }} VND</h4>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref, computed, watch } from "vue";

const click = () =>{
  // localStorage.setItem("gioHang", JSON.stringify(gioHang.value));
  console.log(JSON.parse(localStorage.getItem("gioHang")));
   window.location.href="/thanh-toan-gio-hang"
}
// Lấy dữ liệu từ localStorage (hoặc mảng rỗng nếu chưa có)
const gioHang = ref(JSON.parse(localStorage.getItem("gioHang")) || []);

console.log(gioHang.value);


// Tính tổng tiền dựa trên số lượng và giá
const tongTien = computed(() => {
return gioHang.value.reduce((total, item) => total + item.price * item.quantity, 0);
  
});

// Hàm cập nhật số lượng
const changeQuantity = (index, amount) => {
  gioHang.value[index].quantity += amount;
  gioHang.value[index].amount = 0;
  gioHang.value[index].amount = gioHang.value[index].amount + gioHang.value[index].price * gioHang.value[index].quantity
  // Nếu số lượng <= 0, xóa sản phẩm khỏi giỏ hàng
  if (gioHang.value[index].quantity <= 0) {
    gioHang.value.splice(index, 1);
  }
};

// Hàm xóa sản phẩm khỏi giỏ hàng
const removeProduct = (index) => {
  gioHang.value.splice(index, 1);
};

// Tự động cập nhật localStorage khi `gioHang` thay đổi
watch(gioHang, () => {
  localStorage.setItem("gioHang", JSON.stringify(gioHang.value));
  console.log(localStorage.getItem("gioHang"));  
}, { deep: true });



</script>
