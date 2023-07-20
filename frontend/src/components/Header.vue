<template>
<el-menu :default-active="1" class="el-menu-demo" mode="horizontal" @select="handleSelect">
    <el-menu-item index="1">
        <router-link class='no-underline' to="/">HOME</router-link>
    </el-menu-item>
    <el-menu-item index="3">GIFTS</el-menu-item>
    <el-menu-item index="4">
        <router-link class='no-underline' to="/products">BOOKS</router-link>
    </el-menu-item>
    <el-menu-item index="5">
        <router-link class='no-underline' :to=this.url>{{ loginHeader }}</router-link>
    </el-menu-item>
    <el-menu-item v-show="showElement" index="6">
        <router-link class='no-underline' to="/cart">CART</router-link>
    </el-menu-item>

</el-menu>
</template>

<script>
// import { ref } from 'vue'
// import { mapState } from "vuex";
export default {
    data() {
        return {
            url: "/login",
            loginHeader: "MY ACCOUNT",
            showElement: false
        }
    },
    mounted() {
        if (this.getToken === "" || this.getToken === null || this.getToken === undefined) {
            console.log("in mounted null")
            console.log(this.getToken)
            this.url = "/login"
            this.loginHeader = "LOGIN/REGISTER"
        } else {
            console.log("in mounted not null")
            console.log(this.getToken)
            console.log(this.token)
            this.showElement = true
            this.url = "/userInfo"
        }
    },
    name: 'WebHeader',
    methods: {
        getTokenFromStorage() {
            return localStorage.getExpire("token")
        }
    },
    computed: {
        // ...mapState(["token"])
        getToken() {
            // const tokenStored = localStorage.getExpire("token")
            // return tokenStored
            return this.$store.state.token
        },
        // loginHeader() {
        //     if (this.getToken === "" || this.getToken === null || this.getToken === undefined) {
        //         console.log("in mounted null")
        //         console.log(this.getToken)
        //         // this.url = "/login"
        //         return "LOGIN/REGISTER"
        //     } else {
        //         console.log("in mounted not null")
        //         console.log(this.getToken)
        //         console.log(this.token)
        //         // this.url = "/userInfo"
        //         return "MY ACCOUNT"
        //     }
        // },
        // loginURL(){
        //   if (this.getToken === "" || this.getToken === null || this.getToken === undefined) {
        //         console.log("in mounted null")
        //         console.log(this.getToken)
        //         return "/login"
        //     } else {
        //         console.log("in mounted not null")
        //         console.log(this.getToken)
        //         console.log(this.token)
        //         return "/userInfo"
        //     }
        // }
    }

}
</script>

<style>
.no-underline {
    text-decoration: none;
}
</style>
