int countLargestGroup(int n){
    int i ,j;
    int sum[10001] = {0};
    int a[10001] = {0};
    int b[10001] = {0};
    for( i = 1 ; i <= n ; i++ ){                //�����λ�ͷ���a����
        int x = i;
        int y = 0; 
        while ( x ){                              
		    y = x % 10;
            x /= 10;
            a[i] += y;
	    }
    }
    for ( i = 1 ; i <= n ; i++ ){               //����λ����ͬ��������Ŀ���
        for ( j = 1 ; j <= n ; j++ ){
            if ( i == a[j] )
                sum[i]++;
        }
    }
    int t = 0;
    for ( i = 1 ; i <= n ; i++ ){                  //��С������
		for( j = 1 ; j <= n - i ; j++){
			if (sum[j] > sum[j + 1])
				t = sum[j];
				sum[j] = sum[j + 1];
				sum[j + 1] = t;
		}
    }
    int c[10001] ={0};
    for ( i = 1 ; i <= n ; i++){
        if ( i == sum[i] )
            c[i]++;
    } 
      for ( i = 1 ; i <= n ; i++ ){                  //��С������
		for( j = 1 ; j <= n - i ; j++){
			if (c[j] > c[j + 1])
				t = c[j];
				c[j] = c[j + 1];
				c[j + 1] = t;
		}
    }
   
	
    return c[n];
}
