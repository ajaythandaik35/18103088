
import java.util.Scanner;
import java.util.*;
import java.lang.Math.*;
class A4_q1
{
    public static void main(String[] args)
    {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine(); 
        String temp;
        String[] crops = new String[n];
        for (int i=0;i<n;i++)
        {
            crops[i]=in.nextLine().trim();
        }
        char[][] crops_mat = new char[n][m];
	int i=0;
        while(i<n)
        {
            for(int j=0;j<m; j++)
            {
                crops_mat[i][j] = crops[i].charAt(j);
            }
		i++;
        }
        char[] crop_types = new char[26];

	char c='a';
        while(c<'z')
        {
            crop_types[c-'a'] = c;
		c++;
        }

        System.out.println(rep(crops_mat, 0, 0, n, m, 0, n*m, crop_types));
    }

    public static int rep(char[][] crops_mat, int prsnt_row, int prsnt_col, int n, int m, int prsnt_count, int min_count, char[] crop_types)
    {
        Set<Character> left_up = new HashSet<Character>();
        if(prsnt_row!=0)
        {
            left_up.add(crops_mat[prsnt_row-1][prsnt_col]);
        }
        if(prsnt_col!=0)
        {
            left_up.add(crops_mat[prsnt_row][prsnt_col-1]);
        }
        Set<Character> right_down = new HashSet<Character>();
        if(prsnt_row!=n-1)
        {
            right_down.add(crops_mat[prsnt_row+1][prsnt_col]);
        }
        if(prsnt_col!=m-1)
        {
            right_down.add(crops_mat[prsnt_row][prsnt_col+1]);
        }
        boolean present_left_up = false;
        if(left_up.contains(crops_mat[prsnt_row][prsnt_col]))
        {
            present_left_up = true;
        }
        char[][] new_crops_mat = new char[n][m];
        if(right_down.contains(crops_mat[prsnt_row][prsnt_col]))
        {
            if(present_left_up)
            {
                for(int k=0; k<26; k++)
                {
                    if(!left_up.contains(crop_types[k]) && !right_down.contains(crop_types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_mat[i][j] = crops_mat[i][j];
                            }
                        }
                        new_crops_mat[prsnt_row][prsnt_col] = crop_types[k];
                        if(prsnt_col<m-1)
                        {
                            min_count = Math.min(min_count, rep(new_crops_mat, prsnt_row, prsnt_col+1, n, m, prsnt_count+1, min_count, crop_types));
                        }
                        else if(prsnt_row<n-1)
                        {
                            min_count = Math.min(min_count, rep(new_crops_mat, prsnt_row+1, 0, n, m, prsnt_count+1, min_count, crop_types));
                        }
                        else
                        {
                            return Math.min(prsnt_count+1, min_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(prsnt_col<m-1)
                {
                    min_count = Math.min(min_count, rep(crops_mat, prsnt_row, prsnt_col+1, n, m, prsnt_count, min_count, crop_types));
                }
                else if(prsnt_row<n-1)
                {
                    min_count = Math.min(min_count, rep(crops_mat, prsnt_row+1, 0, n, m, prsnt_count, min_count, crop_types));
                }
                else
                {
                    return Math.min(prsnt_count, min_count);
                }
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(crop_types[k]) && !right_down.contains(crop_types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0; j<m; j++)
                            {
                                new_crops_mat[i][j] = crops_mat[i][j];
                            }
                        }
                        new_crops_mat[prsnt_row][prsnt_col] = crop_types[k];
                        if(prsnt_col<m-1)
                        {
                            min_count = Math.min(min_count, rep(new_crops_mat, prsnt_row, prsnt_col+1, n, m, prsnt_count+1, min_count, crop_types));
                        }
                        else if(prsnt_row<n-1)
                        {
                            min_count = Math.min(min_count, rep(new_crops_mat, prsnt_row+1, 0, n, m, prsnt_count+1, min_count, crop_types));
                        }
                        else
                        {
                            return Math.min(prsnt_count+1, min_count);
                        }
                        break;
                    }
                }

            }
        }
        else
        {
            if(present_left_up)
            {
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(crop_types[k]) && !right_down.contains(crop_types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_mat[i][j] = crops_mat[i][j];
                            }
                        }
                        new_crops_mat[prsnt_row][prsnt_col] = crop_types[k];
                        if(prsnt_col<m-1)
                        {
                            min_count = Math.min(min_count, rep(new_crops_mat, prsnt_row, prsnt_col+1, n, m, prsnt_count+1, min_count, crop_types));
                        }
                        else if(prsnt_row<n-1)
                        {
                            min_count = Math.min(min_count, rep(new_crops_mat, prsnt_row+1, 0, n, m, prsnt_count+1, min_count, crop_types));
                        }
                        else
                        {
                            return Math.min(prsnt_count+1, min_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(prsnt_col<m-1)
                {
                    min_count = Math.min(min_count, rep(crops_mat, prsnt_row, prsnt_col+1, n, m, prsnt_count, min_count, crop_types));
                }
                else if(prsnt_row<n-1)
                {
                    min_count = Math.min(min_count, rep(crops_mat, prsnt_row+1, 0, n, m, prsnt_count, min_count, crop_types));
                }
                else
                {
                    return Math.min(prsnt_count, min_count);
                }
            }
        }
        return min_count;
    }
}

