package com.rx.kuzbassmarks.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rx.kuzbassmarks.R

@Composable
fun getPlaces(): List<Place> {
    val yearsTomskWrite = listOf(
        stringResource(R.string.tomskWrite_year_1),
        stringResource(R.string.tomskWrite_year_2),
        stringResource(R.string.tomskWrite_year_3),
    )
    val yearsKuzFortress = listOf(
        stringResource(R.string.kuzFortress_year_1),
        stringResource(R.string.kuzFortress_year_2),
        stringResource(R.string.kuzFortress_year_3),
        stringResource(R.string.kuzFortress_year_4),
        stringResource(R.string.kuzFortress_year_5),
        stringResource(R.string.kuzFortress_year_6),
        stringResource(R.string.kuzFortress_year_7),
        stringResource(R.string.kuzFortress_year_8),
        stringResource(R.string.kuzFortress_year_9),
        stringResource(R.string.kuzFortress_year_10),
    )
    val yearsKuzDramTheater = listOf(
        stringResource(R.string.kuzDramTheater_year_1),
        stringResource(R.string.kuzDramTheater_year_2),
        stringResource(R.string.kuzDramTheater_year_3),
        stringResource(R.string.kuzDramTheater_year_4),
        stringResource(R.string.kuzDramTheater_year_5)
    )
    val yearsHouseWithClocks = listOf(
        stringResource(R.string.houseWithClocks_year_1),
        stringResource(R.string.houseWithClocks_year_2),
        stringResource(R.string.houseWithClocks_year_3),
        stringResource(R.string.houseWithClocks_year_4),
        stringResource(R.string.houseWithClocks_year_5),
    )
    val yearsKemDramTheater = listOf(
        stringResource(R.string.kemDramTheater_year_1),
        stringResource(R.string.kemDramTheater_year_2),
        stringResource(R.string.kemDramTheater_year_3),
        stringResource(R.string.kemDramTheater_year_4),
        stringResource(R.string.kemDramTheater_year_5),
        stringResource(R.string.kemDramTheater_year_6),
        stringResource(R.string.kemDramTheater_year_7),
        stringResource(R.string.kemDramTheater_year_8),
        stringResource(R.string.kemDramTheater_year_9),
        stringResource(R.string.kemDramTheater_year_10)
    )
    val yearsMuseum = listOf(
        stringResource(R.string.museum_year_1),
        stringResource(R.string.museum_year_2),
        stringResource(R.string.museum_year_3),
        stringResource(R.string.museum_year_4),
        stringResource(R.string.museum_year_5),
        stringResource(R.string.museum_year_6),
        stringResource(R.string.museum_year_7),
        stringResource(R.string.museum_year_8),
        stringResource(R.string.museum_year_9),
        stringResource(R.string.museum_year_10)
    )
    val yearsMainersMonument = listOf(
        stringResource(R.string.mainersMonument_year_1),
        stringResource(R.string.mainersMonument_year_2),
        stringResource(R.string.mainersMonument_year_3),
        stringResource(R.string.mainersMonument_year_4),
        stringResource(R.string.mainersMonument_year_5),
        stringResource(R.string.mainersMonument_year_6)
    )
    val yearsRedMountain = listOf(
        stringResource(R.string.redMountain_year_1),
        stringResource(R.string.redMountain_year_2),
        stringResource(R.string.redMountain_year_3),
        stringResource(R.string.redMountain_year_4),
        stringResource(R.string.redMountain_year_5),
        stringResource(R.string.redMountain_year_6),
        stringResource(R.string.redMountain_year_7)
    )
    val yearsDinosaursHome = listOf(
        stringResource(R.string.dinosaursHome_year_1),
        stringResource(R.string.dinosaursHome_year_2),
        stringResource(R.string.dinosaursHome_year_3),
        stringResource(R.string.dinosaursHome_year_4)
    )
    val yearsShorianPark = listOf(
        stringResource(R.string.shorianPark_year_1),
        stringResource(R.string.shorianPark_year_2),
        stringResource(R.string.shorianPark_year_3),
        stringResource(R.string.shorianPark_year_4),
        stringResource(R.string.shorianPark_year_5),
        stringResource(R.string.shorianPark_year_6),
        stringResource(R.string.shorianPark_year_7)
    )


    val storyLineTomskWrite = listOf(
        stringResource(R.string.tomskWrite_storyLine_1),
        stringResource(R.string.tomskWrite_storyLine_2),
        stringResource(R.string.tomskWrite_storyLine_3),
    )
    val storyLineKuzFortress = listOf(
        stringResource(R.string.kuzFortress_storyLine_1),
        stringResource(R.string.kuzFortress_storyLine_2),
        stringResource(R.string.kuzFortress_storyLine_3),
        stringResource(R.string.kuzFortress_storyLine_4),
        stringResource(R.string.kuzFortress_storyLine_5),
        stringResource(R.string.kuzFortress_storyLine_6),
        stringResource(R.string.kuzFortress_storyLine_7),
        stringResource(R.string.kuzFortress_storyLine_8),
        stringResource(R.string.kuzFortress_storyLine_9),
        stringResource(R.string.kuzFortress_storyLine_10),
    )
    val storyLineKuzDramTheater = listOf(
        stringResource(R.string.kuzDramTheater_storyLine_1),
        stringResource(R.string.kuzDramTheater_storyLine_2),
        stringResource(R.string.kuzDramTheater_storyLine_3),
        stringResource(R.string.kuzDramTheater_storyLine_4),
        stringResource(R.string.kuzDramTheater_storyLine_5)
    )
    val storyLineHouseWithClocks = listOf(
        stringResource(R.string.houseWithClocks_storyLine_1),
        stringResource(R.string.houseWithClocks_storyLine_2),
        stringResource(R.string.houseWithClocks_storyLine_3),
        stringResource(R.string.houseWithClocks_storyLine_4),
        stringResource(R.string.houseWithClocks_storyLine_5),
    )
    val storyLineKemDramTheater = listOf(
        stringResource(R.string.kemDramTheater_storyLine_1),
        stringResource(R.string.kemDramTheater_storyLine_2),
        stringResource(R.string.kemDramTheater_storyLine_3),
        stringResource(R.string.kemDramTheater_storyLine_4),
        stringResource(R.string.kemDramTheater_storyLine_5),
        stringResource(R.string.kemDramTheater_storyLine_6),
        stringResource(R.string.kemDramTheater_storyLine_7),
        stringResource(R.string.kemDramTheater_storyLine_8),
        stringResource(R.string.kemDramTheater_storyLine_9),
        stringResource(R.string.kemDramTheater_storyLine_10)
    )
    val storyLineMuseum = listOf(
        stringResource(R.string.museum_storyLine_1),
        stringResource(R.string.museum_storyLine_2),
        stringResource(R.string.museum_storyLine_3),
        stringResource(R.string.museum_storyLine_4),
        stringResource(R.string.museum_storyLine_5),
        stringResource(R.string.museum_storyLine_6),
        stringResource(R.string.museum_storyLine_7),
        stringResource(R.string.museum_storyLine_8),
        stringResource(R.string.museum_storyLine_9),
        stringResource(R.string.museum_storyLine_10)
    )
    val storyLineMainersMonument = listOf(
        stringResource(R.string.mainersMonument_storyLine_1),
        stringResource(R.string.mainersMonument_storyLine_2),
        stringResource(R.string.mainersMonument_storyLine_3),
        stringResource(R.string.mainersMonument_storyLine_4),
        stringResource(R.string.mainersMonument_storyLine_5),
        stringResource(R.string.mainersMonument_storyLine_6)
    )
    val storyLineRedMountain = listOf(
        stringResource(R.string.redMountain_storyLine_1),
        stringResource(R.string.redMountain_storyLine_2),
        stringResource(R.string.redMountain_storyLine_3),
        stringResource(R.string.redMountain_storyLine_4),
        stringResource(R.string.redMountain_storyLine_5),
        stringResource(R.string.redMountain_storyLine_6),
        stringResource(R.string.redMountain_storyLine_7)
    )
    val storyLineDinosaursHome = listOf(
        stringResource(R.string.dinosaursHome_storyLine_1),
        stringResource(R.string.dinosaursHome_storyLine_2),
        stringResource(R.string.dinosaursHome_storyLine_3),
        stringResource(R.string.dinosaursHome_storyLine_4)
    )
    val storyLineShorianPark = listOf(
        stringResource(R.string.shorianPark_storyLine_1),
        stringResource(R.string.shorianPark_storyLine_2),
        stringResource(R.string.shorianPark_storyLine_3),
        stringResource(R.string.shorianPark_storyLine_4),
        stringResource(R.string.shorianPark_storyLine_5),
        stringResource(R.string.shorianPark_storyLine_6),
        stringResource(R.string.shorianPark_storyLine_7)
    )


    val subPlacesRedMountain = listOf(
        Place(0.2f, 0.2f,
            stringResource(R.string.mainersMonument_title),
            stringResource(R.string.mainersMonument_quickAbout),
            stringResource(R.string.mainersMonument_fullStory),
            yearsRedMountain,
            storyLineRedMountain,
            55.374078499999975,
            86.07845750000001,
            stringResource(R.string.mainersMonument_modelPath)
        ),
        Place(0.2f, 0.2f,
            stringResource(R.string.kemDramTheater_title),
            stringResource(R.string.kemDramTheater_quickAbout),
            stringResource(R.string.kemDramTheater_fullStory),
            yearsKemDramTheater,
            storyLineKemDramTheater,
            55.35559909999999,
            86.0811118,
            stringResource(R.string.kemDramTheater_modelPath)
        )
    )

    val subPlacesKuzFortress = listOf(
        Place(0.55f, 0.65f,
            stringResource(R.string.kuzDramTheater_title),
            stringResource(R.string.kuzDramTheater_quickAbout),
            stringResource(R.string.kuzDramTheater_fullStory),
            yearsKuzDramTheater,
            storyLineKuzDramTheater,
            53.7572836,
            87.12036499999998,
            stringResource(R.string.kuzDramTheater_modelPath)
        ),
        Place(0.55f, 0.65f,
            stringResource(R.string.houseWithClocks_title),
            stringResource(R.string.houseWithClocks_quickAbout),
            stringResource(R.string.houseWithClocks_fullStory),
            yearsHouseWithClocks,
            storyLineHouseWithClocks,
            53.776216900000016,
            87.20238590000001,
            stringResource(R.string.houseWithClocks_modelPath)
        )
    )

    return listOf(
        Place(0.2f, 0.2f,
            stringResource(R.string.tomskWrite_title),
            stringResource(R.string.tomskWrite_quickAbout),
            stringResource(R.string.tomskWrite_fullStory),
            yearsTomskWrite,
            storyLineTomskWrite,
            55.669001699999995,
            85.62399079999999,
            stringResource(R.string.tomskWrite_modelPath)
            ),
        Place(0.25f, 0.25f,
            stringResource(R.string.redMountain_title),
            stringResource(R.string.redMountain_quickAbout),
            stringResource(R.string.redMountain_fullStory),
            yearsRedMountain,
            storyLineRedMountain,
            55.375613,
            86.07183979999998,
            stringResource(R.string.redMountain_modelPath),
            subPlacesRedMountain),
        Place(0.66f, 0.11f,
            stringResource(R.string.museum_title),
            stringResource(R.string.museum_quickAbout),
            stringResource(R.string.museum_fullStory),
            yearsMuseum,
            storyLineMuseum,
            56.20585870000003,
            87.76479309999998,
            stringResource(R.string.museum_modelPath)
            ),
        Place(0.7f, 0.15f,
            stringResource(R.string.dinosaursHome_title),
            stringResource(R.string.dinosaursHome_quickAbout),
            stringResource(R.string.dinosaursHome_fullStory),
            yearsDinosaursHome,
            storyLineDinosaursHome,
            55.892435399999954,
            87.95954830000002,
            stringResource(R.string.dinosaursHome_modelPath)
            ),
        Place(0.55f, 0.65f,
            stringResource(R.string.kuzFortress_title),
            stringResource(R.string.kuzFortress_quickAbout),
            stringResource(R.string.kuzFortress_fullStory),
            yearsKuzFortress,
            storyLineKuzFortress,
            53.7738891,
            87.18161239999999,
            stringResource(R.string.kuzFortress_modelPath),
            subPlacesKuzFortress
            ),
        Place(0.83f, 0.86f,
            stringResource(R.string.shorianPark_title),
            stringResource(R.string.shorianPark_quickAbout),
            stringResource(R.string.shorianPark_fullStory),
            yearsShorianPark,
            storyLineShorianPark,
            52.66630130000003,
            88.52805149999998,
            stringResource(R.string.shorianPark_modelPath)
            )
    )
}
