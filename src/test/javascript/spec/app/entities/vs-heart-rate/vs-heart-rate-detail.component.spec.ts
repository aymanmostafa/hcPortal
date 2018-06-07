/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { VsHeartRateDetailComponent } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate-detail.component';
import { VsHeartRateService } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate.service';
import { VsHeartRate } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate.model';

describe('Component Tests', () => {

    describe('VsHeartRate Management Detail Component', () => {
        let comp: VsHeartRateDetailComponent;
        let fixture: ComponentFixture<VsHeartRateDetailComponent>;
        let service: VsHeartRateService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsHeartRateDetailComponent],
                providers: [
                    VsHeartRateService
                ]
            })
            .overrideTemplate(VsHeartRateDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsHeartRateDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsHeartRateService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new VsHeartRate('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.vsHeartRate).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
