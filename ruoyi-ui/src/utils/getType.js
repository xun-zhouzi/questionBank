import request from "./request";

// 查询类型列表
export default function getType(query) { 
    return request({
        url: '/system/type/list',
        method: 'get',
        params: query
    })
}
