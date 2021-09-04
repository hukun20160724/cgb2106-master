<template>
  <div>
    <!-- 添加面包屑 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>活动管理</el-breadcrumb-item>
      <el-breadcrumb-item>活动列表</el-breadcrumb-item>
      <el-breadcrumb-item>活动详情</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card>
      <el-row :gutter="20">
        <el-col :span="8">
          <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
              <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
        </el-col>
        <el-col :span="3">
           <el-button type="primary" plain="">主要按钮</el-button>
        </el-col>
      </el-row>
    </el-card>
    <!-- 固定表头 -->
     <el-table
         :data="tableData"
         border
         >
         <el-table-column
           fixed
           prop="date"
           label="序号"
           width="70">
         </el-table-column>
         <el-table-column
           prop="name"
           label="用户名"
           width="150">
         </el-table-column>
         <el-table-column
           prop="province"
           label="电话"
           width="150">
         </el-table-column>
         <el-table-column
           prop="city"
           label="邮箱"
           width="150">
         </el-table-column>
         <el-table-column
           prop="address"
           label="状态"
           width="150">
         </el-table-column>
         <el-table-column
           prop="actioning"
           label="操作"
           width="150">
           <!-- <template slot-scope="scope">
             <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
             <el-button type="text" size="small">编辑</el-button>
           </template> -->
         </el-table-column>
       </el-table>
  </div>
</template>

<script>
  // 对外声明组件的属性/方法等参数，药别根组件调用
  export default{
    data() {
      return{
        msg:'这是一个vue的子组件'
      }
    }
  }
</script>

<style>
</style>
