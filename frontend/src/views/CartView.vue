<template>
<page-header class="headerBottom"></page-header>
<div class="mainContent">
    <el-row>
        <el-col v-for="(product, index) in productList" :key="index" :span="4" :offset="index > 0 ? 1 : 0">
            <el-card :body-style="{ padding: '0px'}">
                <img src="../assets/masterAndMagarita.png" class="image" />
                <div style="padding: 14px">
                    <span>ProductName: {{product.product.name}}</span>
                    <div class="bottom">
                        <div>
                            <div>Price: {{product.product.price}}$</div>
                            <div>Num: {{product.productNum}}</div>
                        </div>
                        <div>
                            <el-button text class="button">INCREASE</el-button>
                            <el-button text class="button">DECREASE</el-button>
                        </div>
                    </div>
                </div>
            </el-card>
        </el-col>
    </el-row>
</div>
</template>

<script>
import CartService from '@/services/CartService'
import PageHeader from '@/components/Header.vue'

export default {
    components: {
        PageHeader
    },
    data() {
        return {
            userId: "",
            productList: []
        }
    },
    methods: {
        getCart() {
            this.userId = this.getUserId;
            CartService.getCart(this.userId).then((response) => {
                this.productList = response.data;
                console.log(this.productsList);
            });
        }
    },
    mounted() {
        this.getCart();
    },
    computed: {
        getUserId() {
            return this.$store.state.userId
        }
    }
}
</script>

<style>
.mainContent {
    margin-top: 50px;
    margin-left: 80px;
    margin-right: 80px;
}

.time {
    font-size: 12px;
    color: #999;
}

.bottom {
    margin-top: 13px;
    line-height: 12px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.button {
    padding: 0;
    min-height: auto;
}

.image {
    width: 100%;
    height: 100%;
    display: block;
}
</style>
