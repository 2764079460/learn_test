<template>
  <div class="blogs">
    <Header></Header>

    <el-timeline>
      <el-timeline-item :timestamp="blog.created" placement="top" v-for="(blog, index) in blogs" :key="index">
        <el-card>
          <h4>
            <router-link :to="{name:'blogDetail', params: {blogId: blog.id}}">
              {{blog.title}}
            </router-link>
          </h4>
          <p>{{blog.description}}</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>

    <el-pagination class="mpage" background
                   layout="prev, pager, next"
                   :current-page="currentPage"
                   :page-size="pageSize"
                   :total="total"
                   @current-change="page">
    </el-pagination>
  </div>
</template>
<script>
  import Header from '../components/Header'
  export default {
    name:"blogs",
    data(){
      return {
          blogs: {},
          currentPage: 1,
          total: 0,
          pageSize: 5
      }
    },
    components:{Header},
    created(){
      this.page(1);
    },
    methods:{
        page(currentPage){
          const _this = this;
          _this.$axios.get("/blog/list?currentPage="+currentPage).then(res => {
            _this.blogs = res.data.data.records;
            _this.currentPage = res.data.data.current;
            _this.total = res.data.data.total;
            _this.pageSize = res.data.data.size;
          })
        }
    }
  }
</script>
<style scoped>
  .mpage{
    /*margin: 0 auto;*/
    text-align: center;
  }
</style>
