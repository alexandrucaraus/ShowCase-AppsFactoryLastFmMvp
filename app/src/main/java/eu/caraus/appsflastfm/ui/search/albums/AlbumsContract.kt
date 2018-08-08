package eu.caraus.appsflastfm.ui.search.albums

import android.arch.lifecycle.LifecycleObserver
import eu.caraus.appsflastfm.common.retrofit.Outcome
import eu.caraus.appsflastfm.data.domain.lastFm.albums.AlbumItem
import eu.caraus.appsflastfm.ui.base.BaseContract
import io.reactivex.subjects.PublishSubject

interface AlbumsContract : BaseContract {

    interface Presenter : BaseContract.BasePresenter<View>, LifecycleObserver {

        fun showAlbumDetails( artistName: String, albumName: String )
        fun saveAlbumDetails( artistName: String, albumName: String )

        fun getAlbums( artistId : String )
        fun goBack() : Boolean
    }

    interface View : BaseContract.BaseView {

        fun showFoundAlbums( artists : List<AlbumItem?>)
        fun showFoundNothing()

        fun showLoading()
        fun hideLoading()

        fun showError( error : Throwable )
    }

    interface Interactor {

        fun getAlbums ( albums : String )
        fun getAlbumsOutcome () : PublishSubject<Outcome<List<AlbumItem?>>>

        fun saveAlbum( artistName: String, albumName: String)

    }

    interface Navigator {
        fun showAlbumDetails( artistName : String, albumName : String)
        fun goBack() : Boolean
    }

}