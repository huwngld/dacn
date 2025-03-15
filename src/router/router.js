import {createRouter, createWebHistory} from "vue-router";

import Home from "@/components/Home.vue";
import Sach from "@/components/Sach.vue";
import SignIn from "@/components/signIn.vue";
import DangNhap from "@/components/register.vue";
import ChiTietSanPham from "@/components/chiTietSanPham.vue";
import ThongTinMuaHang from "@/components/ThongTinMuaHang.vue";
import DatHangThanhCong from "@/components/DatHangThanhCong.vue";
import DatHangThatBai from "@/components/DatHangThatBai.vue";
import GioHang from "@/components/GioHang.vue";
import ThanhToanGioHang from "@/components/ThanhToanGioHang.vue";
import AdminLichSuDatHang from "@/components/AdminLichSuDatHang.vue";
import XacNhanDonHang from "@/components/XacNhanDonHang.vue";
import AdminSignIn from "@/components/AdminSignIn.vue";
import AdminXoaSach from "@/components/AdminXoaSach.vue";
import TrangThaiDonHang from "@/components/TrangThaiDonHang.vue";
import error from "@/components/error404.vue";
import Erorr500 from "@/components/erorr500.vue";
const routes = [
  {
    path: "/",
    component: Home,
  },
  {
    path: "/login",
    component: SignIn,
  },
  {
    path: "/register",
    component: DangNhap,
  },
  {
    path: "/chi-tiet-san-pham/:id",
    name: "ResultPage",
    component: ChiTietSanPham,
  },
  {
    path: "/thong-tin-mua-hang/:ma",
    name: "ResultPage1",
    component: ThongTinMuaHang,
  },
  {
    path: "/thanh-cong",
    component: DatHangThanhCong,
  },
  {
    path: "/that-bai",
    component: DatHangThatBai,
  },
  {
    path: "/gio-hang",
    component: GioHang,
  },
  {
    path: "/thanh-toan-gio-hang",
    component: ThanhToanGioHang,
  },
  {
    path: "/lich-su-dat-hang",
    component: AdminLichSuDatHang,
  },
  {
    path: "/xac-nhan-don-hang",
    component: XacNhanDonHang,
  },
  {
    path: "/admin",
    component: AdminSignIn,
  },
  {
    path: "/them-sach",
    component: Sach,
  },
  {
    path: "/hien-thi",
    component: AdminXoaSach,
  },
  {
    path: "/trang-thai",
    component: TrangThaiDonHang,
  },{
    path: "/error",
    component: Erorr500,
  },
  {
    path: "/:catchAll(.*)",
    component: error,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;
