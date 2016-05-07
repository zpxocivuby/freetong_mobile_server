/**
 * 处理数据显示为列表
 * 如果是动态生成的话，这个可以作为模版来实用
 * 
 */
DataProcess = function(jsonData, limitColumns){
    var columns = [
        {id:'id',header: "ID", width: 160, sortable: true, dataIndex: 'id'},
        {header: "用户名称", width: 75, sortable: true, dataIndex: 'userName'},
        {header: "用户类型", width: 75, sortable: true, dataIndex: 'userType'},
        {header: "用户Email", width: 75, sortable: true, dataIndex: 'userEmail'},
        {header: "用户生日", width: 85, sortable: true, dataIndex: 'userBirthday'}
    ];

    if(limitColumns){
        var cs = [];
        for(var i = 0, len = limitColumns.length; i < len; i++){
            cs.push(columns[limitColumns[i]]);
        }
        columns = cs;
    }
    
    var dataArray = new Array();
    for ( var i = 0; i < jsonData.length; i++) {
    	var dataStr = jsonData[i];
    	dataArray[i] = [dataStr.id,dataStr.userName, dataStr.userType, dataStr.userEmail, dataStr.userBirthday];
	}

    DataProcess.superclass.constructor.call(this, {
        store: new Ext.data.Store({
            reader: new Ext.data.ArrayReader({}, [
                   {name: 'id'},
                   {name: 'userName'},
                   {name: 'userType'},
                   {name: 'userEmail'},
                   {name: 'userBirthday'}
              ]),
            data: dataArray
        }),
        columns: columns,
        autoExpandColumn: 'id',
        height:250,
        width:600
    });
};

Ext.extend(DataProcess, Ext.grid.GridPanel);