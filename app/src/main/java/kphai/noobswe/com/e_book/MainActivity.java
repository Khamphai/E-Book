package kphai.noobswe.com.e_book;


import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private View dimView;
    private FloatingActionMenu fam;
    private FloatingActionButton fabChoosePic, fabCamera, fabSearch;

    private MainAdapter adapter;
    private RecyclerView recyclerView;

    private Handler delayAction = new Handler();


    private String[] book_name = {
            "ການຈັດການນະວັດຕະກໍາ",
            "ການຈໍາລອງສະຖານະການເບື້ອງຕົ້ນ",
            "PMcM ຮູ້ກ່ອນສ້າງ",
            "MC ສໍາລັບການຈັດການກໍ່ສ້າງ",
            "CM: ວິຖີຕາເວັນອອກ",
            "ຄິດໃຫ້ໜ້ອຍລົງແລ້ວຈະເຫັນໄດ້ເລິກກວ່າ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ສັບເທັກນິກວິສະວະກໍາໄຟຟ້າກໍາລັງ",
            "ຜູ້ນໍາກັບການຈັດການການປ່ຽນແປງ",
            "ການບໍລິຫານການເງິນທຸລະກິດ: ແນວຄິດ ແລະ ການປະຕິບັດ",
            "ຫານບໍລິຫານງານຄຸນນະພາບໃນອົງກອນ",
            "ການຈັດການເຊີງກົນລະຍຸດ: ການສ້າງ ແລະ ການດໍາເນີນ",
            "ການຈັດການໂຄງການ",
            "ການບໍລິຫານ ຄ່າຈ້າງເງິນເດືອນ",
            "ການຈັດການດໍາເນີນງານ",
            "ການບໍລິຫານສໍານັກງານ",
            "ການຈັດການເຊີງກົນລະຍຸດ",
            "ການພັດທະນາອົງການ",
            "HR Manual and Forms",
            "ເອກະສານລວບລວມ ສັນຍາກ່ຽວກັບວຽກກໍ່ສ້າງ",
            "ຂໍ້ຫ້າມຂໍ້ຈໍາກັດ ຕາມກົດໝາຍຂອງໜ່ວຍງານອື່ນທີ່ກ່ຽວຂ້ອງກັບ ການກໍ່ສ້າງອາຄານໃນເຂດກຸງເທບມະຫານະຄອນ",
            "ຄູ່ມືການສ້າງນະວັດຕະກໍາ ໃນເກີດຂຶ້ນຈິງໃນອົງກອນ",
            "ເທັກນິກການເພີ່ມຜົນຜະລິດໃນອົງກອນ: ຫຼັກການ ແລະ ຕົວຢ່າງການປະຕິບັດ",
            "ການພັດທະນາອົງການ ແລະ ການປ່ຽນແປງ",
            "ການສັນຫາການຄັດເລືອກ ແລະ ການປະເມີນຜົນການປະຕິບັດງານຂອງບຸກຄະລາກອນ",
            "ພຶດຕິກໍາອົງການ ແລະ ການຈັດການ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ຮ້ອຍພັນບັນຫາໃນວຽກການກໍ່ສ້າງ",
            "ນາຍຊ່າງ (ຕົວຈິງ) ກັບໂຮງແຮມຜີສິງ",
            "ການຈັດການຊັບພະຍາກອນທາງກາຍຍະພາບ",
            "ການຈັດການຄວາມຮູ້",
            "ແຄ່ຮູ້ວິທີໃຫ້ ຄົນຮັບໄດ້ເທົ່າໃດ ຄົນໃຫ້ໄດ້ຫຼາຍກວ່າ",
            "ການພັດທະນາອົງການ",
            "ພົດຈະນານຸກົມ ຄໍາສັບວິສະວະກໍາໄຟຟ້າ",
            "ຄູ່ມືແນວທາງການກວດສອບງານຕິດຕັ້ງລະບົບໄຟຟ້າ",
            "ຄູ່ມືການຕິດຕັ້ງລະບົບໄຟຟ້າສໍາລັບຊ່າງ",
            "ຄູ່ມືຄວາມປອດໄພທາງໄຟຟ້າ",
            "ຄູ່ມືການຕິດຕັ້ງເຄື່ອງປັບອາກາດຂະໜາດນ້ອຍ",
            "ຄູ່ມືການຕິດຕັ້ງລະບົບສາຍສັນຍານພາຍໃນອາຄານ",
            "ປະສົບການງານຊ່າງ",
            "ມາດຕະຖານການປ້ອງກັນຟ້າຜ່າ ພາກ 1 ຂໍ້ກໍານົດທົ່ວໄປ",
            "ມາດຕະຖານການປ້ອງກັນຟ້າຜ່າ ພາກ 2 ການບໍລິຫານຄວາມສ່ຽງ",
            "ມາດຕະຖານລະບົບຂັ້ນໄດເລື່ອນ ແລະທາງເລື່ອນອັດຕະໂນມັດ",
            "ຄູ່ມືການກໍານົດຂະໜາດສາຍໄຟຟ້າຕາມມາດຕະຖານໃໝ່",
            "ການໃຊ້ເທັກໂນໂລຢີພາບຖ່າຍຄວາມຮ້ອນອິນຟຣາເຣດຢ່າງມືອາຊີບ",
            "ຄະນິດສາດສໍາລັບວິສະວະກອນໄຟຟ້າສື່ສານ",
            "ມາດຕະຖານການຕິດຕັ້ງທາງໄຟຟ້າໃນສະຖານທີິ່ສະເພາະ: ບໍລິເວນສະຖານພະຍາບານ",
            "ມາດຕະຖານການຕິດຕັ້ງທາງໄຟຟ້າສໍາລັບປະເທດໄທ ພ.ສ 2556",
            "ມາດຕະຖານການປ້ອງກັນຟ້າຜ່າ ພາກທີ 4 ລະບົບໄຟຟ້າ ແລະ ເອເລັກໂທນິກພາຍໃນສິ່ງປຸກສ້າງ",
            "ມາດຕະຖານການປ້ອງກັນຟ້າຜ່າ ພາກທີ 3 ຄວາມເສຍຫາຍທາງກາຍຍະພາບຕໍ່ສິ່ງປຸກສ້າງ ແລະ ອັນຕະລາຍຕໍ່ຊີວິດ",
            "ມາດຕະຖານຄວາມປອດໄພທາງໄຟຟ້າໃນສະຖານທີ່ເຮັດວຽກ (ພ.ສ 2557)",
            "ຄູ່ມືຄວາມປອດໄພດ້ານໄຟຟ້າແຮງສູງ",
            "ຄູ່ມືຄຸນນະພາບໄຟຟ້າ",
            "ຄູ່ມືການອອກແບບຫ້ອງສະອາດ",
            "ມາດຕະຖານການປ້ອງກັນອັກຄີໄພສໍາລັບໂຮງງານອຸດສາຫະກໍາ",
            "ມາດຕະຖານຄວບຄຸມຄວັນໄຟ",
            "ມາດຕະຖານລະບົບເຄື່ອງກົນຂົນສົ່ງໃນອາຄານ",
            "ຄູ່ມືປະຕິບັດວິຊາຊີບການອອກແບບລະບົບຜະລິດໄຟຟ້າພະລັງງານແສງອາທິດສໍາລັບອາຄານໃນປະເທດໄທ",
            "ທັກນິກການກວດສອບອາຄານເພື່ອຄວາມປອດໄພ",
            "ສັນຍານ ແລະ ລະບົບ",
            "ມາດຕະຖານລະບົບການໃຊ້ກາສທໍາມະຊາດເປັນເຊື້ອເພີງໃນຍານຍົນ",
            "ວິສະວະກໍາຄວາມປອດໄພ : ພື້ນຖານຂອງວິສະວະກອນ",
            "ປະສົບການວິສະວະກໍາງານລະບົບ ລະບົບປ້ອງກັນອັກຄີໄພ",
            "ອຸມົງລົດໄຟຟ້າລອດແມ່ນໍາເຈົ້າພະຍາຄັ້ງທໍາອິດໃນເມືອງໄທ",
            "ມາດຕະຖານການປ້ອງກັນອັກຄີໄພ",
            "ບັນຫາໃນການກໍ່ສ້າງ",
            "ເກັດຄວາມຮູ້ກ່ຽວກັບການຄວບຄຸມງານກໍ່ສ້າງອາຄານຄອນກຣີດເສີມເຫຼັກ",
            "ການວິເຄາະໂຄງສ້າງ",
            "ທໍລະນີວິທະຍາວິສະວະກໍາ",
            "ແນວທາງປະຕິບັດວິຊາຊີບວິສະວະກໍາສໍາລັບວິສະວະກອນໃໝ່",
            "ມາດຕະຖານສໍາລັບອາຄານຄອນກຣິດເສີມເຫຼັກໂດຍວິທີໜ່ວແຮງໃຊ້ງານ",
            "ການອອກແບພື້ນຄອນກຣີດອັດແຮງໄຮ້ຄານ",
            "ແນວທາງການບໍລິຫານໂຄງການ ແລະ ຄວບຄຸມງານກໍ່ສ້າງ",
            "ມາດຕະຖານສໍາລັບອາຄານເຫຼັກຮູບປະພັນ"};

    String[] name = {
            "ພະຍັດ ວຸດທົງ",
            "ຜສ.ດຣ ປຣະຈວບ ກລ່ອມຈິດ",
            "ນິທິ ສະຖາປິຕານົນ",
            "ດຣ. ເຣິງນະຣົງ ຣັດຕະນະປີຊາເວດ",
            "ດຣ. ເຣິງນະຣົງ ຣັດຕະນະປີຊາເວດ",
            "MALCOLM GLADWELL",
            "ນິວັດ ເຫຼືອງອະພິຊາດ",
            "ຍອດຍ່ຽມ ເທບຊານົນ",
            "ຍອດຍ່ຽມ ເທບຊານົນ",
            "ນາຍ ສຸວັດ ເຊົາປຣີຊາ",
            "ພິຊາພົບ ພັນທຸແພ",
            "ເສກສັກ ຈໍາເລີນວົງ",
            "ອະນຸສັກ ສິ່ນໄພສານ",
            "ດຣ. ທຣຣສະນະ ບຸນຂວັນ",
            "ຍອດຍ່ຽມ ເທບຊານົນ",
            "ດຣ. ປະເວດ ມະຫາຣັດຕະນະກຸລ",
            "Russell & Taylor",
            "ສຸຣັສວະດີ ຮາຊກຸລໄຊ",
            "ດຣ. ສຸດໃຈ ດິລົກທັດສະນົນ",
            "ດຣ. ກັນຍາຣັຕ ທີຣະທົນໄຊກຸລ",
            "ດຣ. ອາພອນ ພູ່ວິທຍາພັນ",
            "ສະມາຄົມສະຖາປານິກສະຫຍາມ",
            "ສ.ດຣ. ພິສິດ ກາຣສຸດທິ",
            "ສັດຈະ ຈຣັສຣຸ່ງທວີວອນ",
            "ຜສ.ດຣ ປຣະຈວບ ກລ່ອມຈິດ",
            "ຮສ ດຣ. ເນຕຣພັດທະນາ ຍາວີຣາຊ",
            "ຊູໄຊ ສມິທທິໄກຣ",
            "ຜສ.ດຣ ສຸທໍາ ຣັຕນະໂຊດ",
            "ສະມິດ ໂອບາຍະວາທ",
            "ຍອດຍ່ຽມ ເທບຊານົນ",
            "ຍອດຍ່ຽມ ເທບຊານົນ",
            "ຍອດຍ່ຽມ ເທບຊານົນ",
            "ສຸວິມົນ ສັຈຈວານິດຍ",
            "ນັນທະນາ ອຸຕມເພທາຍ",
            "ຮສຈ. ດຣ. ສົມຊາຍ ນໍາປຣະເສຣິໄຊ",
            "ອະດໍາ ແກຣນ",
            "ດຣ ກັລຍາຣັດ ທີຣະທົນໄຊກຸລ",
            "ສຈ.ດຣ. ມົງຄົນ ເດຊະນະຄຣິນ",
            "ທັກສິນ ວັຊຣະວິທຍາກຸລ",
            "ໂສກນ ເຫຼົ່າສຸວັນ",
            "ໂສກນ ເຫຼົ່າສຸວັນ",
            "ເຊີດສັກ ວິທູນຣາພອນ",
            "ເຊີດສັກ ວິທູນຣາພອນ",
            "ເຊີດສັກ ວິທູນຣາພອນ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ຊັດຊະວາລ ຄຸນຄໍ້າຊູ",
            "ອະນັນ ກິດຕິວິທຍາກຸລ",
            "ດຣ. ຍຸທຣພົງ ທັພດຸງ",
            "ດຣ. ສຸສັກ ທອງທໍາມະຊາດ",
            "ສຈ.ດຣ. ບຸນຣອດ ບິນສັນ",
            "ອາທອນ ສິນສະຫວັດ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ສຈ ດຣ ສຸຊັຊວີ ສຸວັນສະຫວັດ",
            "ສຈ.ດຣ. ບຸນຣອດ ບິນສັນ",
            "ສຸວັດ ເຊົາປີຊາ",
            "ສຸວັດ ເຊົາປີຊາ",
            "ຮສ ດຣ ຕະກຸລ ຍົມນາກ",
            "ດຣ ກາຣຸນ ຈັນທຣາງສຸ",
            "ດຣ ກາຣຸນ ຈັນທຣາງສຸ",
            "ພິໄຊ ວົງໄວຍະວັນ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ຮສ ດຣ ເອກ ໄຊສະຫວັດ",
            "ດຣ ກາຣຸນ ຈັນທຣາງສຸ",
            "ກິດຕິ ອິນທຣານົນ",
            "ເກຊາ ທີຣະໂກເມນ",
            "ເກຊາ ທີຣະໂກເມນ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ໄພບູລ ກິດຕິພິທຍາກອນ",
            "ອາຣຸນ ໄຊເສລີ",
            "ສຸນິຕິ ສຸພາບ",
            "ຮສ ດຣ ວັຊຣິນ ກາສລັກ",
            "ສຈ ດຣ ສຸຊັຊວີ ສຸວັນສະຫວັດ",
            "ດຣ ໄກຣວຸດ ກຽດໂກມົນ",
            "ມັ່ນ ສີເຣືອນທອງ",
            "ປຣະສົງ ທາຣາໄຊ",
            "ສຈ ອາຣຸນ ໄຊເສລີ"};

    public int[] image = {
            R.drawable.ic_book_1, R.drawable.ic_book_2,
            R.drawable.ic_book_3, R.drawable.ic_book_4,
            R.drawable.ic_book_5, R.drawable.ic_book_6,
            R.drawable.ic_book_7, R.drawable.ic_book_8,
            R.drawable.ic_book_9, R.drawable.ic_book_10,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading};


    String[] types = {
            "ໄຟຟ້າ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ບຸກຄະລາກອນ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ການບໍລິຫານ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ",
            "ໄຟຟ້າ"};

    String[] nameE = {
            "INOVATIO MANAGEMENT",
            "Introduction to Simulation",
            "",
            "MC FOR CM",
            "CM the Eastern Way",
            "",
            "",
            "",
            "",
            "",
            "Leedership and Change Managament",
            "Corporate Financial Management: Concept and Application",
            "RISK MANAGEMENT",
            "CRAFTINGG & EXECUTING STRATERGY",
            "Project Management",
            "Wage & Salary Administration",
            "Operation Management",
            "Office Management",
            "Strategic Management",
            "Organization Development",
            "",
            "",
            "",
            "101 Design Methods",
            "Productivity Improvement: Principle and Practice",
            "Organization Development and Change",
            "",
            "Organizational Behavior and Management",
            "",
            "",
            "",
            "",
            "",
            "Facility Management",
            "Knowledge Management",
            "Give and Take",
            "Organization Development",
            "",
            "Inspection of Electrical Installation Handbook",
            "Electrical Instalation Handbook",
            "Electrical Safety Handbook",
            "Room Air Conditioners Installation Handbook",
            "Network Cabling Installation Handbook",
            "",
            "Thai Standard: Protection against lightning Part 1 Principles",
            "Thai Standard : Protection against lightning Part 2 Risk Management",
            "Escalators and Moving Walks Safety Code",
            "",
            "Professional Infrared Thermography",
            "",
            "Electrical Instation : Medical Location",
            "Thai Electrict Code 2013",
            "Thai Standard: Protection against linhtning Part 4 Electrical and Electronic Systems within Structures",
            "Thai Standard: Protection against linhtning Part 3 Physical Damage to Structures and Life Hazard",
            "Electrical Safety in The Workplace (2014)",
            "",
            "",
            "Cleanrooms Desesign Manual",
            "",
            "",
            "",
            "",
            "",
            "Signals and Systems",
            "Road vehicles-Compressed natural gas (CNG) fuel systems",
            "",
            "",
            "",
            "",
            "",
            "",
            "Fundamentals of Structurul Analysis",
            "",
            "",
            "",
            "Design of Post-tensioned Flat Slab",
            "",
            "",};


    String[] ISBN = {
            "978-974-03-3172-8",
            "978-974-7197-72-3",
            "978-616-7800-60-8",
            "978-974-235-624-8",
            "978-616-91049-02",
            "978-616-287-140-5",
            "",
            "",
            "",
            "978-974-7197-77-8",
            "978-974-03-2845-2",
            "978-974-466-423-5",
            "978-616-08-2341--3",
            "978-616-70603-2-3",
            "978-616-90213-3-9",
            "978-616-210-143-4",
            "978-616-282-001-4",
            "974-13-2583-5",
            "978-616-394-076-6",
            "978-616-08-2229-4",
            "978-616-7444-14-7",
            "974-85739-5-8",
            "",
            "978-616-200-582-4",
            "978-616-08-2159-4",
            "978-999-010-016-7",
            "978-974-03-3067-7",
            "978-974-9918-46-43",
            "",
            "974-93686-0-6",
            "974-91412-5-3",
            "",
            "978-974-7197-99-0",
            "978-616-90213-1-5",
            "978-616-08-2208-9",
            "978-616-287-143-6",
            "978-616-08-229-4",
            "974-7197-42-1",
            "978-616-91996",
            "978-974-05-0227-2",
            "978-974-05-0221-0",
            "978-974-225-389-9",
            "978-974-7539-68-4",
            "978-974-7197-75-4",
            "978-974-7197-68-6",
            "978-974-7197-69-3",
            "978-974-8104-76-8",
            "978-616-91996-1-8",
            "978-974-7197-81-5",
            "974-89779-4-3",
            "978-974-7197-63-1",
            "978-974-7197-86-0",
            "978-974-7197-71-6",
            "978-974-7197-70-9",
            "978-974-7197-93-8",
            "978-974-7197-66-2",
            "978-974-7197-76-1",
            "978-974-7197-74-7",
            "974-7197-37-5",
            "974-90720-8-1",
            "974-7197-40-5",
            "978-616-7384-17-7",
            "978-974-7197-60-0",
            "974-87774-9-9",
            "978-974-7197-49-9",
            "974-03-0151-7",
            "974-7197-14-6",
            "",
            "978-974-7197-56-3",
            "978-616-374-353-4",
            "978-974-7197-65-5",
            "978-616-382-7-0",
            "978-974-7197-95-2",
            "",
            "974-858-145-4",
            "978-616-396-000-9",
            "978-974-7197-57-0",
            "974-86266-0-1"};

    String[] location = {
            "ສໍານັກພິມມະຫາວິທະຍາໄລຈຸລາລົງກອນ",
            "ໂຮງພິມແຫ່ງມະຫາວິທະຍາໄລຈຸລາລົງກອນ",
            "ບໍລິສັດ ລາຍເຊັ້ນ ພັບບຣິດຊິ່ງ",
            "ສ, ເອເຊຍ ພາເລສ",
            "ສ, ເອເຊຍ ພາເລສ",
            "ສໍານັກພິມວີເລີນ",
            "ໂຮງພິມແລທທິດເວີກ ຈໍາກັດ",
            "",
            "",
            "ບໍລິສັດ ຈຸດທອງ ຈໍາກັດ",
            "ສໍານັກພິມມະຫາວິທະຍາໄລຈຸລາລົງກອນ",
            "ໂຮງພິມມະຫາວິທະຍາໄລທໍາມະສາດ",
            "ພິມທີ່ບໍລິສັດ ພີ.ພຣິ້ນ ຈໍາກັດ",
            "Mc Graw Hill Education",
            "ບໍລິສັດພລັດເພລສ ຈໍາກັດ",
            "ສໍານັກພິມປັນຍາຊົນ",
            "ບໍລິສັດສໍານັກພິມ ທັອບ ຈໍາກັດ",
            "ສໍານັກພິມມະຫາວິທະຍາໄລຈຸລາລົງກອນ",
            "",
            "ບໍລິສັດ ດີເອັດຢູເຄຊັ່ນ",
            "ບໍລິສັດເອສ ອາ ເຊັນເຕີ ຈໍາກັດ",
            "ໂຮງພິມເມດຊາເພຣສ",
            "ສະມາຄົມວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "",
            "ບໍລິສັດ ດີເອັດຢູເຄຊັ່ນ",
            "ບໍລິສັດ ທຣິບເພິ້ນ ກຣຸບ",
            "ພິມທີ່ບໍລິສັດ ພີ.ພຣິ້ນ ຈໍາກັດ",
            "ບໍລິສັດສໍານັກພິມ ທັອບ ຈໍາກັດ",
            "",
            "",
            "",
            "",
            "ສະມາຄົມວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "",
            "ບໍລິສັດຊີເອສຢູເຄຊັ່ນ",
            "ສໍານັກພິມວີເລີນ",
            "ບໍລິສັດຊີເອສຢູເຄຊັ່ນ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ສະມາຄົມຊ່າງເໝາະໄຟຟ້າ ແລະ ເຄື່ອງກົນໄທ",
            "",
            "",
            "ສະມາຄົມຊ່າງເໝາະໄຟຟ້າ ແລະ ເຄື່ອງກົນໄທ",
            "ສະມາຄົມຊ່າງເໝາະໄຟຟ້າ ແລະ ເຄື່ອງກົນໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ສະມາຄົມລິບ ແຫ່ງປະເທດໄທ",
            "ສະມາຄົມຊ່າງເໝາະໄຟຟ້າ ແລະ ເຄື່ອງກົນໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ສະມາຄົມສະຖາປານິກສະຍາມ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ດີພ້ອມການພິມ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ",
            "ວິສະວະກໍາສະຖານແຫ່ງປະເທດໄທ"};

    String[] pages = {
            "251",
            "155",
            "264",
            "160",
            "247",
            "255",
            "469",
            "250",
            "211",
            "260",
            "366",
            "579",
            "249",
            "407",
            "124",
            "402",
            "363",
            "403",
            "475",
            "291",
            "477",
            "",
            "314",
            "336",
            "503",
            "361",
            "431",
            "471",
            "150",
            "152",
            "208",
            "36",
            "157",
            "",
            "163",
            "395",
            "291",
            "1055",
            "137",
            "129",
            "222",
            "107",
            "114",
            "135",
            "",
            "",
            "112",
            "74",
            "97",
            "589",
            "1-ງ8",
            "",
            "1-ຈ28",
            "1-ຈ112",
            "44",
            "259",
            "353",
            "272",
            "133",
            "29",
            "171",
            "202",
            "330",
            "",
            "",
            "306",
            "79",
            "",
            "319",
            "363",
            "288",
            "449",
            "331",
            "143",
            "95",
            "",
            "44",
            "111"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        fabMenu();


    }

    private void fabMenu() {
        dimView = findViewById(R.id.dim_view);
        fam = (FloatingActionMenu) findViewById(R.id.fam);
        fabCamera = (FloatingActionButton) findViewById(R.id.fab_camera);
        fabChoosePic = (FloatingActionButton) findViewById(R.id.fab_choosepic);
        fabSearch = (FloatingActionButton) findViewById(R.id.fab_search);

        final int famAnimationDuration = 50;
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean open) {
                if (open) {
                    dimView.setVisibility(View.VISIBLE);
                    dimView.animate().alpha(0.7f).setDuration(300).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            fam.getMenuIconView().animate()
                                    .alpha(0f)
                                    .setDuration(famAnimationDuration)
                                    .start();
                            delayAction.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    fam.getMenuIconView().setImageResource(R.drawable.fab_add);
                                    fam.getMenuIconView().invalidate();
                                    fam.getMenuIconView().animate()
                                            .alpha(1f)
                                            .setDuration(famAnimationDuration)
                                            .start();
                                }
                            }, famAnimationDuration);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    }).start();
                } else {
                    dimView.animate().alpha(0.0f).setDuration(300).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            delayAction.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    fam.getMenuIconView().animate()
                                            .alpha(0f)
                                            .setDuration(famAnimationDuration)
                                            .start();
                                    delayAction.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            fam.getMenuIconView().setImageResource(R.drawable.ic_library_books_white_24dp);
                                            fam.getMenuIconView().invalidate();
                                            fam.getMenuIconView().animate()
                                                    .alpha(1f)
                                                    .setDuration(famAnimationDuration)
                                                    .start();
                                        }
                                    }, famAnimationDuration);
                                }
                            }, 150);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            dimView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    }).start();
                }
            }
        });
        dimView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fam.close(true);
            }
        });

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);

                fam.close(true);
            }
        });
        fabChoosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);

                fam.close(true);
            }
        });

        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You Click Share App", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Archiineer Library");
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_app_bar);
        toolbar.setLogoDescription(R.string.app_name);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        adapter = new MainAdapter(this, book_name, name, image);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addItemDecoration(new GridMarginDecoration(this, 2, 2, 2, 2));
        //recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new OnGridItemSelectedListener(this, new OnGridItemSelectedListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getApplicationContext(), "H"+position, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("book_name", book_name[position]);
                intent.putExtra("name", name[position]);
                intent.putExtra("position", position);
                intent.putExtra("type", types[position]);
                intent.putExtra("isbn", ISBN[position]);
                intent.putExtra("nameE", nameE[position]);
                intent.putExtra("location", location[position]);
                intent.putExtra("pages", pages[position]);
                startActivity(intent);

            }
        }));

    }

     private long backPressedTime = 0;
    @Override
    public void onBackPressed() {        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 3 secs
            backPressedTime = t;
//            Toast.makeText(this, "Press back again to exit",
//                    Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar
                .make(collapsingToolbarLayout, "Press back again to exit", Snackbar.LENGTH_LONG);

            snackbar.show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    } // end of onBackPressed


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            //Do what you want

            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();

            //wanted
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
