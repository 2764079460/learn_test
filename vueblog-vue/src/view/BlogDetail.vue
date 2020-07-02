<template>
  <div class="blogDetail">
    <Header></Header>
    <div class="mblog">
      <h2>{{blog.title}}</h2>
      <el-link icon="el-icon-edit" v-if="showEdit">
        <router-link :to="{name: 'blogEdit', params: {blogId: blog.id}}">编辑</router-link>
      </el-link>
      <el-divider></el-divider>
      <div class="markdown-body" v-html="blog.content"></div>
    </div>
  </div>
</template>
<script>
  import 'github-markdown-css'
  import Header from '../components/Header'
  export default {
    name:"blogDetail",
    components:{Header},
    data(){
      return {
        blog: {
          id: '',
          title: '',
          description: '',
          content: ''
        },
        showEdit: false
      }
    },
    created(){
      const blogId = this.$route.params.blogId;
      console.log(blogId);
      const _this = this;
      if(blogId) {
        _this.$axios.get("/blog/"+blogId).then(res => {
          _this.blog = res.data.data;
          let MarkdownIt = require("markdown-it");
          let md = new MarkdownIt();
          let result = md.render(_this.blog.content);
          _this.blog.content = result;
          _this.showEdit = (_this.blog.userId == _this.$store.getters.getUser.id);
        })
      }
    }
  }
</script>
<style scoped>
  .mblog{
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 100%;
    min-height: 700px;
    padding: 20px 15px;
  }
</style>
