package com.hackatit.challenges.helpmeunpack;


import com.hackatit.challenges.CommonUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Base64;

public class HelpMeUnpack {

    public static void main(String[] args) {

        CommonUtil util = new CommonUtil();
        HelpMeUnpackProblem problem = util.getProblem("https://hackattic.com/challenges/help_me_unpack/problem", HelpMeUnpackProblem.class);

        HelpMeUnpackSolution solution = new HelpMeUnpackSolution();

        byte[] bytes = Base64.getDecoder().decode(problem.getBytes());

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);

        solution.setSignedInt(byteBuffer.getInt());
        solution.setUnSignedInt(Integer.toUnsignedLong(byteBuffer.getInt()));
        solution.setaShort(byteBuffer.getShort());
        byteBuffer.getShort(); // to skip next 2 bytes
        solution.setaFloat(byteBuffer.getFloat());
        solution.setaDouble(byteBuffer.getDouble());
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        solution.setBigEndianDouble(byteBuffer.getDouble());


        String result = util.sendSolution("https://hackattic.com/challenges/help_me_unpack/solve", solution);

        System.out.println(solution + "\n" + result);

    }


}
