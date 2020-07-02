import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/view/Login'
import blogs from '@/view/Blogs'
import blogEdit from '@/view/BlogEdit'
import blogDetail from '@/view/BlogDetail'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'index',
      redirect:{name: "blogs"}
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/blogs',
      name: 'blogs',
      component: blogs
    },
    {
      path: '/blog/add',
      name: 'blogAdd',
      component: blogEdit,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/blog/:blogId',
      name: 'blogDetail',
      component: blogDetail
    },
    {
      path: '/blog/:blogId/edit',
      name: 'blogEdit',
      component: blogEdit,
      meta: {
        requireAuth: true
      }
    }
  ]
})
