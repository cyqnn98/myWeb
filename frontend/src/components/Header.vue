<template>
<el-menu
    :default-active="1"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
  >
    <el-menu-item index="1">
        <router-link class='no-underline' to="/">HOME</router-link>
    </el-menu-item>
    <el-menu-item index="3">GIFTS</el-menu-item>
    <el-menu-item index="4">
        <router-link class='no-underline' to="/products">BOOKS</router-link>
    </el-menu-item>
  </el-menu>
</template>

<script>
// import { ref } from 'vue'
export default{
    name:'WebHeader'
}
</script>

<style>
.no-underline {
  text-decoration: none;
}
</style>
