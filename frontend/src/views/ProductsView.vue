<template>
<div class="mainContent">
    <el-row>
        <el-col v-for="(product, index) in productsList" :key="index" :span="4" :offset="index > 0 ? 1 : 0">
            <el-card :body-style="{ padding: '0px'}">
                <img src="../assets/masterAndMagarita.png" class="image" />
                <div style="padding: 14px">
                    <span>{{product.name}}</span>
                    <div class="bottom">
                        <span>Price: {{product.price}}$</span>
                        <el-button text class="button">BUY</el-button>
                    </div>
                </div>
            </el-card>
        </el-col>
    </el-row>
</div>
</template>

<script>
import ProductsService from '@/services/ProductsService'

export default {
    data() {
        return {
            currentDate: new Date(),
            productsList: []

        }
    },
    methods: {
        getProducts() {
            ProductsService.getAllProducts().then((response) => {
                this.productsList = response.data;
                console.log(this.productsList);
            });
        }
    },
    mounted() {
        this.getProducts();
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
