import { createRouter, createWebHistory } from 'vue-router'

import Home from '@/components/Home.vue'
import Sach from '@/components/Sach.vue'
import SignIn from '@/components/signIn.vue'
import DangNhap from '@/components/register.vue'
import ChiTietSanPham from '@/components/chiTietSanPham.vue'
import ThongTinMuaHang from '@/components/ThongTinMuaHang.vue'


const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/login',
        component: SignIn
    },
    {
        path: '/register',
        component: DangNhap
    },
    {
        path: '/chi-tiet-san-pham/:id',
        name: 'ResultPage',
        component: ChiTietSanPham
    },
    {
        path: '/thong-tin-mua-hang/:ma',
        name: 'ResultPage1',
        component: ThongTinMuaHang
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router
