<template>
  <div class="m-content">
    <h3>欢迎来到博客</h3>
    <div class="block">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
      <div>{{user.username}}</div>
    </div>
    <div class="maction">
      <span><el-link href="/vueblog-vue/blogs">主页</el-link></span>
      <el-divider direction="vertical"></el-divider>
      <span><el-link type="success" href="/vueblog-vue/blog/add">发表博客</el-link></span>

      <el-divider direction="vertical"></el-divider>
      <span v-show="user.username == '请先登录'"><el-link type="primary" href="/vueblog-vue/login">登录</el-link></span>
      <span v-show="user.username != '请先登录'"><el-link type="danger" @click="logout">退出</el-link></span>
    </div>
  </div>
</template>
<script>
  export default{
      name: 'Header',
      data () {
        return {
          user:{
              username:'请先登录',
              avatar:''
          }
        }
      },
      created(){
        if(this.$store.getters.getUser && this.$store.getters.getUser.username){
          this.user.username = this.$store.getters.getUser.username;
          this.user.avatar = this.$store.getters.getUser.avatar;
        }
      },
      methods:{
          logout(){
            const _this = this;
            _this.$axios.get("/account/logout", {
              headers: {
                "Authorization": localStorage.getItem("token")
              }
            }).then(res => {
              _this.$store.commit("REMOVE_INFO");
              _this.$router.push("/login");
            })
          }
      }
  }
</script>
<style scoped>
  .m-content {
    max-width: 960px;
    margin: 0 auto;
    text-align: center;
  }
  .maction{
    margin: 10px;

  }

</style>
