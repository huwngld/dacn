<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';
const danhSach1 = ref([]);
const danhSach2 = ref([]);
const danhSach3 = ref([]);

onMounted(() => {
    if(localStorage.getItem("token") === null){
            window.location.href = "/"
        }
    axios.get("http://localhost:8080/sach/")
        .then(response => {
            const data = response.data;
            danhSach1.value = data.ds1 || [];
            danhSach2.value = data.ds2 || [];
            danhSach3.value = data.ds3 || [];
        })
        .catch(error => {
            console.error("Lỗi khi lấy dữ liệu:", error);
        });
});
let token = JSON.parse(localStorage.getItem("token"))
const dl = ref({
    imgFile: null,
    tenSach: '',
    tacGia: '',
    theLoai: '',
    nhaXuatBan: '',
    soLuongTon: '',
    giaBan: ''
});

const handleFileUpload = (event) => {
    dl.value.imgFile = event.target.files[0];
};

const getDl = () => {
    // Tạo FormData để gửi file và dữ liệu
    const formData = new FormData();
    
    // Thêm file nếu có
    if (dl.value.imgFile) {
        formData.append('imgFile', dl.value.imgFile);
    }
    
    // Thêm các trường dữ liệu khác
    formData.append('tenSach', dl.value.tenSach);
    formData.append('tacGia', dl.value.tacGia);
    formData.append('theLoai', dl.value.theLoai);
    formData.append('nhaXuatBan', dl.value.nhaXuatBan);
    formData.append('soLuongTon', dl.value.soLuongTon);
    formData.append('giaBan', dl.value.giaBan);
    
    axios.post("http://localhost:8080/admin/add-sach", formData, {
        headers: {
            'Content-Type': 'multipart/form-data',
            Authorization: `Bearer ${token}`
        }
    })
    .then(response => {
        console.log("Thêm sách thành công:", response.data);
        alert('Thêm sách thành công')
    })
    .catch(error => {
        console.error("Lỗi khi thêm sách:", error);
    });
};


</script>

<template>
    <form @submit.prevent="getDl" method="post" enctype="multipart/form-data" class="p-5">
        <div class="mb-3">
            <label for="img" class="form-label">Hình Ảnh</label>
            <input type="file" class="form-control" id="img" @change="handleFileUpload">
        </div>

        <div class="mb-3">
            <label for="tenSach" class="form-label">Tên Sách</label>
            <input type="text" class="form-control" id="tenSach" v-model="dl.tenSach" required>
        </div>

        <div class="mb-3">
            <label for="tacGia" class="form-label">Tác Giả</label>
            <select class="form-select" id="tacGia" v-model="dl.tacGia">
                <option :value="ds.maTacGia" v-for="ds in danhSach1">
                    {{ds.tenTacGia}}
                </option>
            </select>
        </div>

        <div class="mb-3">
            <label for="theLoai" class="form-label">Thể Loại</label>
            <select class="form-select" id="theLoai" v-model="dl.theLoai">
                <option :value="ds.maTheLoai" v-for="ds in danhSach2">
                    {{ ds.tenTheLoai }}
                </option>
            </select>
        </div>

        <div class="mb-3">
            <label for="nhaXuatBan" class="form-label">Nhà Xuất Bản</label>
            <select class="form-select" id="nhaXuatBan" v-model="dl.nhaXuatBan">
                <option :value="ds.maNhaXuatBan" v-for="ds in danhSach3" :key="ds.tenNhaXuatBan">
                    {{ ds.tenNhaXuatBan }}
                </option>
            </select>
        </div>

        <div class="mb-3">
            <label for="soLuongTon" class="form-label">Số Lượng Tồn</label>
            <input type="number" class="form-control" id="soLuongTon" v-model="dl.soLuongTon" required>
        </div>

        <div class="mb-3">
            <label for="giaBan" class="form-label">Giá Bán (VNĐ)</label>
            <input type="number" step="0.01" class="form-control" id="giaBan" v-model="dl.giaBan" required>
        </div>

        <button type="submit" class="btn btn-primary m-5" name="button" value="add" @click="test">Lưu Sách</button>
    </form>
</template>